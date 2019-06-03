<div class="form-group ${invalid ? 'has-error' : ''}">
    <label for="${property}">${label} ${required ? '*' : ''}</label>

    <div class="input-group mb-3" >
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1"> <i class="fas fa-1x fa-calendar"></i></span>
        </div>
        <f:widget property="${property}"/>
        <g:if test="${errors}">
            <g:each in="${errors}" var="error">
                <div class="invalid-feedback"><g:message error="${error}"/></div>
            </g:each>
        </g:if>
    </div>
</div>
