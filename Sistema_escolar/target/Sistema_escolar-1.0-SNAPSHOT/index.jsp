<%@page import="com.emergentes.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>

<%
    List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>
       
        <div class="container">
             <h1>LOGIN</h1>
                    <form action="MainControllerIniciar" method="post">
            <label>Correo</label>
            <input class="form-control" type="text" name="correo"><br>
            <label>Contraseña</label>
            <input class="form-control" type="password" name="password"><br>
            <input class="btn btn-success" type="submit" value="Iniciar sesion">
            <a class="btn btn-primary" href="MainController?op=nuevo">Registrarse</a>
        </form>

        
        </div>

       
    </body>
</html>
