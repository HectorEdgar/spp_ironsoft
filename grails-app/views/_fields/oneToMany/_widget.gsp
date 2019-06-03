association one to many
<select class="form-control" id="exampleFormControlSelect1" name="${property}">
    <g:each in="${bean.list()}" var="p">
        <option value="${p.id}">${p}</option>
    </g:each>
</select>
<g:if test="${bean.list().size()==0}">
    <g:link controller="${property.toString()}" class="btn btn-secondary" action="create"><g:message code="default.new.label" args="[property]" /></g:link>
</g:if>
