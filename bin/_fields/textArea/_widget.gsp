<g:if test="${required}">
    <g:textArea name="${property}" required="required" class="form-control ${errors?"is-invalid":""}">${vaule}</g:textArea>
</g:if>
<g:else>
    <g:textArea name="${property}" class="form-control ${errors?"is-invalid":""}">${vaule}</g:textArea>
</g:else>