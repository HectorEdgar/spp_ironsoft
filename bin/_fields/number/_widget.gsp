<g:if test="${required}">
    <g:field type="number" name="${property}" value="${value}" required="${required}" class="form-control ${errors?"is-invalid":""}"/>
</g:if>
<g:else>
    <g:field type="number" name="${property}" value="${value}" class="form-control ${errors?"is-invalid":""}"/>
</g:else>
