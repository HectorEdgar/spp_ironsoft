package ironsoft


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class CategoriaController {

    CategoriaService categoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaService.list(params), model:[categoriaCount: categoriaService.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond categoriaService.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new Categoria(params)
    }
    @Secured(['permitAll'])
    def save(Categoria categoria) {
        if (categoria == null) {
            notFound()
            return
        }

        try {
            categoriaService.save(categoria)
        } catch (ValidationException e) {
            respond categoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoria.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de categoria"
                redirect categoria
            }
            '*' { respond categoria, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond categoriaService.get(id)
    }
    @Secured(['permitAll'])
    def update(Categoria categoria) {
        if (categoria == null) {
            notFound()
            return
        }

        try {
            categoriaService.save(categoria)
        } catch (ValidationException e) {
            respond categoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoria.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de categoria"
                redirect categoria
            }
            '*'{ respond categoria, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        categoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoria.label', default: 'Categoria'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de categoria"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoria.label', default: 'Categoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
