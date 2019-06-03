package ironsoft

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmpleadoController {

    EmpleadoService empleadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empleadoService.list(params), model:[empleadoCount: empleadoService.count()]
    }

    def show(Long id) {
        respond empleadoService.get(id)
    }

    def create() {
        respond new Empleado(params)
    }

    def save(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado)
        } catch (ValidationException e) {
            respond empleado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                redirect empleado
            }
            '*' { respond empleado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond empleadoService.get(id)
    }

    def update(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado)
        } catch (ValidationException e) {
            respond empleado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                redirect empleado
            }
            '*'{ respond empleado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empleadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empleado.label', default: 'Empleado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empleado.label', default: 'Empleado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
