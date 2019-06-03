<%=packageName ? "package ${packageName}" : ''%>


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['permitAll'])
class ${className}Controller {

    ${className}Service ${propertyName}Service

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ${propertyName}Service.list(params), model:[${propertyName}Count: ${propertyName}Service.count()]
    }
    @Secured(['permitAll'])
    def show(Long id) {
        respond ${propertyName}Service.get(id)
    }
    @Secured(['permitAll'])
    def create() {
        respond new ${className}(params)
    }
    @Secured(['permitAll'])
    def save(${className} ${propertyName}) {
        if (${propertyName} == null) {
            notFound()
            return
        }

        try {
            ${propertyName}Service.save(${propertyName})
        } catch (ValidationException e) {
            respond ${propertyName}.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: '${propertyName}.label', default: '${className}'), ${propertyName}.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Creación de ${propertyName}"
                redirect ${propertyName}
            }
            '*' { respond ${propertyName}, [status: CREATED] }
        }
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        respond ${propertyName}Service.get(id)
    }
    @Secured(['permitAll'])
    def update(${className} ${propertyName}) {
        if (${propertyName} == null) {
            notFound()
            return
        }

        try {
            ${propertyName}Service.save(${propertyName})
        } catch (ValidationException e) {
            respond ${propertyName}.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: '${propertyName}.label', default: '${className}'), ${propertyName}.id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Actualización de ${propertyName}"
                redirect ${propertyName}
            }
            '*'{ respond ${propertyName}, [status: OK] }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ${propertyName}Service.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: '${propertyName}.label', default: '${className}'), id])
                flash.icon = "check"
                flash.messageType = "success"
                flash.title = "Eliminación de ${propertyName}"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: '${propertyName}.label', default: '${className}'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
