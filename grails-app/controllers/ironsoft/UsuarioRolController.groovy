package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class UsuarioRolController {

    UsuarioRolService usuarioRolService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond usuarioRolService.list(params), model:[usuarioRolCount: usuarioRolService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond usuarioRolService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new UsuarioRol(params)
    }
    @Secured(['permitAll'])
    def save(UsuarioRol usuarioRol) {
        if (usuarioRol == null) {
            notFound()
            return
        }

        try {
            usuarioRolService.save(usuarioRol)
        } catch (ValidationException e) {
            respond usuarioRol.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), usuarioRol.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de usuarioRol"
                redirect usuarioRol
            }
            '*' { respond usuarioRol, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond usuarioRolService.get(id)
    }
    @Secured(['permitAll'])
    def update(UsuarioRol usuarioRol) {
        if (usuarioRol == null) {
            notFound()
            return
        }

        try {
            usuarioRolService.save(usuarioRol)
        } catch (ValidationException e) {
            respond usuarioRol.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), usuarioRol.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de usuarioRol"
                redirect usuarioRol
            }
            '*'{ respond usuarioRol, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usuarioRolService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de usuarioRol"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarioRol.label', default: 'UsuarioRol'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
