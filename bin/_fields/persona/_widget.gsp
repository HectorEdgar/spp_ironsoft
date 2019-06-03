<select class="form-control" id="exampleFormControlSelect1" name="${property}">
    <g:each in="${bean.list()}" var="p">
        <option value="${p.id}">${p}</option>
    </g:each>
</select>
