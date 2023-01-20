package post

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostController {

    PostService postService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", list: "GET"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render([posts: postService.list(params), postCount:postService.count()] as JSON)
    }

    def show(Long id) {
        if (id == null) {
            notFound()
            return
        }
        render( [post:postService.get(id)] as JSON)
    }

    def save(Post post) {
        if (post == null) {
            notFound()
            return
        }

        try {
            postService.save(post)
        } catch (ValidationException e) {
            render([post: post,error:post.errors, status: BAD_REQUEST.value()] as JSON)
            return
        }

        render([post: post, status: CREATED.value()] as JSON)
    }

    def update(Long id) {
        if (id == null) {
            notFound()
            return
        }
        Post post = postService.get(id)
        if (!post){
            notFound()
            return
        }
        post.properties = request.getJSON()
        try {
            postService.save(post)
        } catch (ValidationException e) {
            render([post: post,error:post.errors, status: BAD_REQUEST.value()] as JSON)
            return
        }

        render([post: post, status: OK.value()] as JSON)
    }

    def delete() {
        if (params.id == null) {
            notFound()
            return
        }

        postService.delete(params.id)

        render([status: OK.value()] as JSON)
    }

    def patch(Long id) {
        if (id == null) {
            notFound()
            return
        }

        Post post = postService.get(id)
        try {
            post.properties = request.getJSON()
            postService.save(post)
        } catch (ValidationException e) {
            render([post: post,error:post.errors, status: BAD_REQUEST.value()] as JSON)
            return
        }

        render([post: post, status: OK.value()] as JSON)
    }

    protected void notFound() {
        render([status: NOT_FOUND.value()] as JSON)
    }
}
