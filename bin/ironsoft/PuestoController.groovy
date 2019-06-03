package ironsoft

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PuestoController {

    PuestoService puestoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond puestoService.list(params), model:[puestoCount: puestoService.count()]
    }

    def show(Long id) {
        respond puestoService.get(id)
    }

    def create() {
        respond new Puesto(params)
    }

    def save(Puesto puesto) {
        if (puesto == null) {
            notFound()
            return
        }

        try {
            puestoService.save(puesto)
        } catch (ValidationException e) {
            respond puesto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'puesto.label', default: 'Puesto'), puesto.id])
                redirect puesto
            }
            '*' { respond puesto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond puestoService.get(id)
    }

    def update(Puesto puesto) {
        if (puesto == null) {
            notFound()
            return
        }

        try {
            puestoService.save(puesto)
        } catch (ValidationException e) {
            respond puesto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'puesto.label', default: 'Puesto'), puesto.id])
                redirect puesto
            }
            '*'{ respond puesto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        puestoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'puesto.label', default: 'Puesto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'puesto.label', default: 'Puesto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
