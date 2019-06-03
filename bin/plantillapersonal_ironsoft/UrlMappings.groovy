package plantillapersonal_ironsoft

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "usuario", action: "inicio")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
