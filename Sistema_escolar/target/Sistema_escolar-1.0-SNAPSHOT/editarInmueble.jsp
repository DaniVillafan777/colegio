<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Inmueble"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%@page import="com.emergentes.modelo.Usuario"%>


<%
    Inmueble inmue = (Inmueble) request.getAttribute("inmue");

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
            <c:if test="${inmue.id_i == 0}">Registro</c:if>
            <c:if test="${inmue.id_i != 0}">Editar Inmueble</c:if>
            </h1>
            <form action="MainControllerInmueble" method="post">
                <input type="hidden" name="id_i" value="${inmue.id_i}">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input class="form-control" type="text" name="nombre" value="${inmue.nombre}"></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input class="form-control" type="number" name="cantidad" value="${inmue.cantidad}"></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td><input class="form-control" type="text" name="estado" value="${inmue.estado}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-success" type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
