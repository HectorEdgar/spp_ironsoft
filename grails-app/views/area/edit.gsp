<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="sb-admin" />
    <g:set var="entityName" value="${message(code: 'area.label', default: 'Area')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
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
            <li class="breadcrumb-item active" aria-current="page"><g:message code="default.edit.label" args="[entityName]" /></li>
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
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
    <g:hasErrors bean="${this.area}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.area}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.area}" method="PUT" autocomplete="off">
        <g:hiddenField name="version" value="${this.area?.version}" />
        <fieldset class="form">
            <f:all bean="area"/>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
