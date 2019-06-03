<g:if test="${required}">
    <g:textField name="${property}" value="${value}" required="required"
                 class="form-control ${errors ? "is-invalid" : ""}" maxlength="${constraints.maxSize}"/>
</g:if>
<g:else>
    <g:textField name="${property}" value="${value}" class="form-control ${errors ? "is-invalid" : ""}"
                 maxlength="${constraints.maxSize}"/>
</g:else>
