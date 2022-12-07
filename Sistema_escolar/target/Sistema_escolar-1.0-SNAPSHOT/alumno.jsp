<%@page import="com.emergentes.modelo.Alumno"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%
    List<Alumno> lista_a = (List<Alumno>)request.getAttribute("lista_a");

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
        <h1>Lista de Alumnos</h1>

        <p><a class="btn btn-primary" href="MainControllerAlumno?op=nuevo">Nuevo</a></p>
        <table class="table table-striped" border = 1>
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>C.I</th>
                <th>Rude</th>
                <th>Curso</th>
                <th>Grado</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="item_a" items="${lista_a}">
                <tr>
                    <td>${item_a.id_alum}</td>
                    <td>${item_a.nombre}</td>
                    <td>${item_a.apellido}</td>
                    <td>${item_a.ci}</td>
                    <td>${item_a.rude}</td>
                    <td>${item_a.curso}</td>
                    <td>${item_a.grado}</td>
                    <td><a class="btn btn-warning" href="MainControllerAlumno?op=editar&id=${item_a.id_alum}">Editar</a></td>
                    <td><a class="btn btn-danger" href="MainControllerAlumno?op=eliminar&id=${item_a.id_alum}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-success" href="inicio.jsp">Volver</a>
    </body>
</html>

