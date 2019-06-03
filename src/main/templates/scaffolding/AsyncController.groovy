<%=packageName ? "package ${packageName}" : ''%>


import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import org.springframework.transaction.TransactionStatus
@Secured(['permitAll'])
class ${className}Controller {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        ${className}.async.task {
            [${propertyName}List: list(params), count: count() ]
        }.then { result ->
            respond result.${propertyName}List, model:[${propertyName}Count: result.count]
        }
    }
    @Secured(['permitAll'])
    def show(Long id) {
        ${className}.async.get(id).then { ${propertyName} ->
            respond ${propertyName}
        }
    }
    @Secured(['permitAll'])
    def create() {
        respond new ${className}(params)
    }
    @Secured(['permitAll'])
    def save(${className} ${propertyName}) {
        ${className}.async.withTransaction { TransactionStatus status ->
            if (${propertyName} == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            if(${propertyName}.hasErrors()) {
                status.setRollbackOnly()
                respond ${propertyName}.errors, view:'create' // STATUS CODE 422
                return
            }

            ${propertyName}.save flush:true
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
    }
    @Secured(['permitAll'])
    def edit(Long id) {
        ${className}.async.get(id).then { ${propertyName} ->
            respond ${propertyName}
        }
    }
    @Secured(['permitAll'])
    def update(Long id) {
        ${className}.async.withTransaction { TransactionStatus status ->
            def ${propertyName} = ${className}.get(id)
            if (${propertyName} == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            ${propertyName}.properties = params
            if( !${propertyName}.save(flush:true) ) {
                status.setRollbackOnly()
                respond ${propertyName}.errors, view:'edit' // STATUS CODE 422
                return
            }

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: '${className}.label', default: '${className}'), ${propertyName}.id])
                    flash.icon = "check"
                    flash.messageType = "success"
                    flash.title = "Actualización de ${propertyName}"
                    redirect ${propertyName}
                }
                '*'{ respond ${propertyName}, [status: OK] }
            }
        }
    }
    @Secured(['permitAll'])
    def delete(Long id) {
        ${className}.async.withTransaction { TransactionStatus status ->
            def ${propertyName} = ${className}.get(id)
            if (${propertyName} == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            ${propertyName}.delete flush:true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: '${className}.label', default: '${className}'), ${propertyName}.id])
                    flash.icon = "check"
                    flash.messageType = "success"
                    flash.title = "Eliminación de ${propertyName}"
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
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