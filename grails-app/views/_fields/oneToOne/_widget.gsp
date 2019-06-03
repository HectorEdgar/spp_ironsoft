association widget one to one
${bean.list()}
-
${value}
<select class="form-control" id="${property}" name="${property}">
    <g:each in="${bean.properties}" var="p">
        <option value="${p}">${p}</option>
    </g:each>
</select>
<g:if test="${bean.list().size()==0}">
    <g:link controller="${property.toString()}" class="btn btn-secondary" action="create"><g:message code="default.new.label" args="[property]" /></g:link>
</g:if>

${columnProperties}