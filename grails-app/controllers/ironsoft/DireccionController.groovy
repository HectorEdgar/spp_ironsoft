package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class DireccionController {

    DireccionService direccionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond direccionService.list(params), model:[direccionCount: direccionService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond direccionService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Direccion(params)
    }
    @Secured(['permitAll'])
    def save(Direccion direccion) {
        if (direccion == null) {
            notFound()
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'direccion.label', default: 'Direccion'), direccion.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de direccion"
                redirect direccion
            }
            '*' { respond direccion, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond direccionService.get(id)
    }
    @Secured(['permitAll'])
    def update(Direccion direccion) {
        if (direccion == null) {
            notFound()
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'direccion.label', default: 'Direccion'), direccion.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de direccion"
                redirect direccion
            }
            '*'{ respond direccion, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        direccionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'direccion.label', default: 'Direccion'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de direccion"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'direccion.label', default: 'Direccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
