package ironsoft

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CoordinacionController {

    CoordinacionService coordinacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond coordinacionService.list(params), model:[coordinacionCount: coordinacionService.count()]
    }

    def show(Long id) {
        respond coordinacionService.get(id)
    }

    def create() {
        respond new Coordinacion(params)
    }

    def save(Coordinacion coordinacion) {
        if (coordinacion == null) {
            notFound()
            return
        }

        try {
            coordinacionService.save(coordinacion)
        } catch (ValidationException e) {
            respond coordinacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coordinacion.label', default: 'Coordinacion'), coordinacion.id])
                redirect coordinacion
            }
            '*' { respond coordinacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond coordinacionService.get(id)
    }

    def update(Coordinacion coordinacion) {
        if (coordinacion == null) {
            notFound()
            return
        }

        try {
            coordinacionService.save(coordinacion)
        } catch (ValidationException e) {
            respond coordinacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'coordinacion.label', default: 'Coordinacion'), coordinacion.id])
                redirect coordinacion
            }
            '*'{ respond coordinacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        coordinacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'coordinacion.label', default: 'Coordinacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coordinacion.label', default: 'Coordinacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
