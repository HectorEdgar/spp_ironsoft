package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class AreaController {

    AreaService areaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond areaService.list(params), model:[areaCount: areaService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond areaService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Area(params)
    }
    @Secured(['permitAll'])
    def save(Area area) {
        if (area == null) {
            notFound()
            return
        }

        try {
            areaService.save(area)
        } catch (ValidationException e) {
            respond area.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'area.label', default: 'Area'), area.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de area"
                redirect area
            }
            '*' { respond area, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond areaService.get(id)
    }
    @Secured(['permitAll'])
    def update(Area area) {
        if (area == null) {
            notFound()
            return
        }

        try {
            areaService.save(area)
        } catch (ValidationException e) {
            respond area.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'area.label', default: 'Area'), area.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de area"
                redirect area
            }
            '*'{ respond area, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        areaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'area.label', default: 'Area'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de area"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'area.label', default: 'Area'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
