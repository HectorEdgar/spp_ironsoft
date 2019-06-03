package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class PersonaController {

    PersonaService personaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personaService.list(params), model:[personaCount: personaService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond personaService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Persona(params)
    }
    @Secured(['permitAll'])
    def save(Persona persona) {
        if (persona == null) {
            notFound()
            return
        }

        try {
            personaService.save(persona)
        } catch (ValidationException e) {
            respond persona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'persona.label', default: 'Persona'), persona.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de persona"
                redirect persona
            }
            '*' { respond persona, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond personaService.get(id)
    }
    @Secured(['permitAll'])
    def update(Persona persona) {
        if (persona == null) {
            notFound()
            return
        }

        try {
            personaService.save(persona)
        } catch (ValidationException e) {
            respond persona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'persona.label', default: 'Persona'), persona.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de persona"
                redirect persona
            }
            '*'{ respond persona, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'persona.label', default: 'Persona'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de persona"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'persona.label', default: 'Persona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
