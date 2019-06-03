package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class CoordinacionController {

    CoordinacionService coordinacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond coordinacionService.list(params), model:[coordinacionCount: coordinacionService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond coordinacionService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Coordinacion(params)
    }
    @Secured(['permitAll'])
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
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de coordinacion"
                redirect coordinacion
            }
            '*' { respond coordinacion, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond coordinacionService.get(id)
    }
    @Secured(['permitAll'])
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
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de coordinacion"
                redirect coordinacion
            }
            '*'{ respond coordinacion, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        coordinacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'coordinacion.label', default: 'Coordinacion'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de coordinacion"
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
