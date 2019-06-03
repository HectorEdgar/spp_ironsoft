<!doctype html>
<html>
<head>
    <meta name="layout" content="sb-admin"/>
    <title>Bienvenido al Sistema de Plantilla de Personal</title>
</head>
<body>
<h3><sec:ifLoggedIn>Bienvenido:<i> <sec:username/></i></sec:ifLoggedIn></h3>
<sec:ifNotLoggedIn>
    <h4>Inicia sesión para utilizar las funciones del</h4>
</sec:ifNotLoggedIn>
</body>
</html>
