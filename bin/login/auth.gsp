<!doctype html>
<html>
<head>
    <meta name="layout" content="sb-admin" />
    <title>Iniciar sesión</title>
</head>
<body>
<div class="col-5 mx-auto">
    <g:if test="${params.login_error == '1'}">
        <div class="alert alert-danger text-center">
            Datos incorrectos, intente nuevamente.
        </div>
    </g:if>
</div>
<div class="col-12"></div>
<div class="col-5 mx-auto">
    <div class="card mx-auto" >
        <div class="card-header">
            <div class="text-center">
                <br />
                <h4>
                    <strong>
                        Sistema P-P
                    </strong>
                </h4>
            </div>
        </div>

        <div class="card-body">
            <g:form controller="login" action="authenticate" method="POST">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <span class="fa fa-user"></span>
                        </span>
                    </div>
                    <input type="text" class="form-control" maxlength=50 minlength=4 placeholder="Usuario" name="username" required>
                </div>
                <div  class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <span class="fa fa-key"></span>
                        </span>
                    </div>
                    <input type="password" class="form-control" placeholder="Contrase&ntilde;a"minlength="4" maxlength="50" name="password" required>
                </div>

                <button type="submit" class="btn btn-primary btn-block  mx-auto">
                    Iniciar sesión
                </button>
            </g:form>
        </div>
    </div>

</div>

</body>
</html>