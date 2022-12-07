<%@page import="com.emergentes.modelo.Personal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Usuario"%>


<%
    Personal perso = (Personal) request.getAttribute("perso");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema escolar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>
                        <div class="">
            <nav class="navbar navbar-dark bg-primary">
                <div class="container-fluid">
                    
                    <a class="navbar-brand" href="MainControllerPersonal">Personal</a><br>
                    <a class="navbar-brand" href="MainControllerInmueble">Inmueble</a><br>
                    <a class="navbar-brand" href="TutorController">Tutores</a><br>
                    <a class="navbar-brand" href="MainControllerAlumno">Alumnos</a><br>
                    <a class="navbar-brand" href="MainController">Usuarios</a><br>
                    <a class="navbar-brand" href="index.jsp">Cerrar Sesion</a>
                </div>
            </nav>
        </div>
        <h1>
            <c:if test="${perso.id_p == 0}">Registro</c:if>
            <c:if test="${perso.id_p != 0}">Editar Personal</c:if>
            </h1>
            <form action="MainControllerPersonal" method="post">
                <input type="hidden" name="id_p" value="${perso.id_p}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input class="form-control" type="text" name="nombre" value="${perso.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input class="form-control" type="text" name="apellido" value="${perso.apellido}"></td>
                </tr>
                <tr>
                    <td>Cargo</td>
                    <td><input class="form-control" type="text" name="cargo" value="${perso.cargo}"></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input class="form-control" type="text" name="direccion" value="${perso.direccion}"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input class="form-control" type="text" name="telefono" value="${perso.telefono}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-success" type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>