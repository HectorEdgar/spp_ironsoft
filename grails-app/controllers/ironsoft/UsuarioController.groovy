package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class UsuarioController {

    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def loggedIn () {
        //def usuarioRol = UsuarioRol.findByUsuario(getAuthenticatedUser())
        redirect(uri:"/")
    }

    def inicio(){
        if (isLoggedIn()) {
            return null
        }else {
            redirect(uri: "/login/auth")
        }

    }
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond usuarioService.list(params), model:[usuarioCount: usuarioService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond usuarioService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Usuario(params)
    }
    @Secured(['permitAll'])
    def save(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }
        println(usuario.persona.fechaNacimiento)
        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de usuario"
                redirect usuario
            }
            '*' { respond usuario, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond usuarioService.get(id)
    }
    @Secured(['permitAll'])
    def update(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de usuario"
                redirect usuario
            }
            '*'{ respond usuario, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        UsuarioRol.findByUsuario(Usuario.findById(id)).delete()
        usuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de usuario"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
