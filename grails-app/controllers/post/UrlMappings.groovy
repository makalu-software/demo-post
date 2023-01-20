package post

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'clientConfig', action: 'index')
        "500"(controller: 'index', action: 'error')
        "404"(controller: 'index',action: 'notFound')
        //"/posts" (resource: "post", excludes: ['patch'])

        group "/posts", {
            get "/"(controller: 'post', action: 'index')
            get "/${id}"(controller: 'post', action: 'show')
            put "/${id}"(controller: 'post', action: 'update')
            post "/"(controller: 'post', action: 'save')
            delete "/${id}"(controller: 'post', action: 'delete')
            patch "/${id}"(controller: 'post', action: 'patch')
        }
    }
}
