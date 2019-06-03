<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="ironsoft">

    <title>
        <g:layoutTitle/>
    </title>
    <asset:stylesheet src="application.css"/>
    <!-- Custom fonts for this template-->
    <asset:stylesheet src="/fontawesome-free/css/all.min.css"/>

    <g:layoutHead/>
</head>

<body id="page-top" class="sidebar-toggled">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="${createLink(uri: '/')}">S.P.P</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <label class="text-white"><sec:ifLoggedIn>Bienvenido: <sec:username/></sec:ifLoggedIn></label>
    </div>

    <!-- Navbar -->
    <ul class="navbar-nav toggle ml-auto ml-md-0">

        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <sec:ifLoggedIn>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Cerrar sesión</a>
                </div>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <g:link class="dropdown-item" uri="/login/auth">Iniciar sesión</g:link>
                </div>
            </sec:ifNotLoggedIn>
        </li>
    </ul>
</nav>

<div id="wrapper">
    <!-- Sidebar -->
    <ul class="sidebar navbar-nav toggled">
        <li class="nav-item active">
            <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="usuario" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Usuario</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Menu: Usuario</h6>
                    <a class="dropdown-item" href="${createLink(controller: 'usuario', action: 'index')}">Lista de usuarios</a>
                    <a class="dropdown-item" href="${createLink(controller: 'usuario', action: 'create')}">Crear usuario</a>
                </div>
            </li>
        </sec:ifAnyGranted>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <h6 class="dropdown-header">Login Screens:</h6>
                <a class="dropdown-item" href="login.html">Login</a>
                <a class="dropdown-item" href="register.html">Register</a>
                <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
                <div class="dropdown-divider"></div>
                <h6 class="dropdown-header">Other Pages:</h6>
                <a class="dropdown-item" href="404.html">404 Page</a>
                <a class="dropdown-item" href="blank.html">Blank Page</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="fas fa-fw fa-table"></i>
                <span>Tables</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <g:layoutBody/>
                </div>
            </div>
        </div>
        <br>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>IronSoft 2018</span>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.content-_wrapper.gsp -->

</div>
<!-- /#_wrapper.gsp -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro de que deseas salir?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Selecciona "Cerrar sesión" si estas listo para terminar tu sesión.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <g:form controller="logout">
                    <button type="submit" name="logout" class="btn btn-danger btn-flat">
                        Cerrar sesión
                    </button>
                </g:form>

            </div>
        </div>
    </div>
</div>

<asset:javascript src="application.js"/>

<!-- Demo scripts for this page-->

<asset:javascript src="datatables-demo.js"/>
<script>
    if(!!window.performance && window.performance.navigation.type === 2)
    {
        //console.log('Reloading');
        window.location.reload();
    }
    $('#datepicker').datepicker({
        format: "yyyy-mm-dd"
        <g:if test="${value}">
        , defaultViewDate: { year: ${value.format('yyyy')}, month: ${value.format('MM')}, day: ${value.format('dd')}}
        </g:if>
    });
</script>
</body>
</html>
