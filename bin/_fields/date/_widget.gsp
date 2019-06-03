<g:if test="${required}">
    <g:textField name="${property}" placeholder="yyyy-mm-dd" id="datepicker" value="${value?.format('yyyy-MM-dd')}" required="required" class="form-control ${errors?"is-invalid":""}"/>
</g:if>
<g:else>
    <g:textField name="${property}" placeholder="yyyy-mm-dd" id="datepicker" value="${value?.format('yyyy-MM-dd')}" class="form-control ${errors?"is-invalid":""}"/>
</g:else>
