<div class="form-group ${invalid ? 'has-error' : ''}">
    <label for="${property}">${label} ${required ? '*' : ''}</label>

    <div>
        <f:widget property="${property}" />
        <g:if test="${errors}">
            <g:each in="${errors}" var="error">
                <div class="invalid-feedback"><g:message error="${error}"/></div>
            </g:each>
        </g:if>
    </div>
</div>
