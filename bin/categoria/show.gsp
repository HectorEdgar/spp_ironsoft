<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="sb-admin" />
    <g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<div class="col-12 justify-content-end">
    <g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
</div>
<div class="col-12">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${createLink(uri: '/')}">Inicio</a></li>
            <li class="breadcrumb-item"><g:link action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            <li class="breadcrumb-item active" aria-current="page"><g:message code="default.show.label" args="[entityName]" /></li>
        </ol>
    </nav>
    <g:if test="${flash.message}">
        <div class="alert alert-${flash?.messageType} alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <h4><i class="icon fa fa-${flash?.icon}"></i>${flash?.title}</h4>
            ${flash?.message}
        </div>
    </g:if>
</div>
<div class="col-12">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="categoria" />
    <g:form resource="${this.categoria}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-info" action="edit" resource="${this.categoria}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
            <input class="btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
