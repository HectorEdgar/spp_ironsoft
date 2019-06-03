<g:if test="${required}">
    <g:select name="${property}" from="${constraints.inList}" value="${value}" class="form-control ${errors?"is-invalid":""}"/>
</g:if>
<g:else>
    <g:select name="${property}" from="${constraints.inList}" value="${value}" noSelection="[null: '']" class="form-control ${errors?"is-invalid":""}"/>
</g:else>
