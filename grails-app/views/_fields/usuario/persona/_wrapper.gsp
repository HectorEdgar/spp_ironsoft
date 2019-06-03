<div class="card">

    <div class="card-header ${invalid ? 'has-error' : ''}">
        <label  for="${property}">${label} ${required ? '*' : ''}</label>
    </div>

    <ul class="list-group list-group-flush">
        <f:widget property="${property}"/>
        <g:if test="${errors}">
            <g:each in="${errors}" var="error">
                <span class="alert alert-danger"><g:message error="${error}"/></span>
            </g:each>
        </g:if>
    </ul>
</div>