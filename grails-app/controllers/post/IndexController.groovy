package post

import grails.converters.JSON

class IndexController {

    def notFound() {
        render([status: 400] as JSON)
    }

    def error() {
        render([status: 500] as JSON)
    }
}
