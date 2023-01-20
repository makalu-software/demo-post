package post

class Post {
    String title
    String author
    static constraints = {
        title blank: false, nullable: false
        author blank: false, nullable: false
    }
}
