<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="sb-admin" />
    <g:set var="entityName" value="${message(code: 'empleado.label', default: 'Empleado')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<br>
<div class="col-12 justify-content-end">
    <g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
</div>
<div class="col-12">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${createLink(uri: '/')}">Inicio</a></li>
            <li class="breadcrumb-item active" aria-current="page"><g:message code="default.list.label" args="[entityName]" /></li>
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
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${empleadoList}" />
</div>
</body>
</html>