<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Tutor"%>


<%
    Tutor tut = (Tutor)request.getAttribute("tut");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <c:if test="${tut.id == 0}">Registro</c:if>
            <c:if test="${tut.id != 0}">Editar Tutor</c:if>
            </h1>
            <form action="TutorController" method="post">
                <input type="hidden" name="id_t" value="${tut.id}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input class="form-control" type="text" name="nombre" value="${tut.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input class="form-control" type="text" name="apellido" value="${tut.apellido}"></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input class="form-control" type="text" name="direccion" value="${tut.direccion}"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input class="form-control" type="text" name="telefono" value="${tut.telefono}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-success" type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
