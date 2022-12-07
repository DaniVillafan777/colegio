<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Tutor"%>
<%
    List<Tutor> lista = (List<Tutor>) request.getAttribute("lista");
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
                <h1>Lista de tutores</h1>
        <p><a class="btn btn-primary"  href="TutorController?op=nuevo">Nuevo</a></p>
        <table class="table table-striped" border = 1>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.direccion}</td>
                    <td>${item.telefono}</td>
                    <td><a class="btn btn-warning" href="TutorController?op=editar&id=${item.id}">Editar</a></td>
                    <td><a class="btn btn-danger" href="TutorController?op=eliminar&id=${item.id}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-success" href="inicio.jsp">Volver</a>
    </body>
</html>
