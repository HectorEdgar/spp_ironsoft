package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class EmpleadoController {

    EmpleadoService empleadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empleadoService.list(params), model:[empleadoCount: empleadoService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond empleadoService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Empleado(params)
    }
    @Secured(['permitAll'])
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
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de empleado"
                redirect empleado
            }
            '*' { respond empleado, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond empleadoService.get(id)
    }
    @Secured(['permitAll'])
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
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de empleado"
                redirect empleado
            }
            '*'{ respond empleado, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empleadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empleado.label', default: 'Empleado'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de empleado"
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
