<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%
    List<Personal> lista_p = (List<Personal>) request.getAttribute("lista_p");

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
        <h1>Lista de personal</h1>

        <p><a class="btn btn-primary" href="MainControllerPersonal?op=nuevo">Nuevo</a></p>
        <table class="table table-striped" border = 1>
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Cargo</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="item_p" items="${lista_p}">
                <tr>
                    <td>${item_p.id_p}</td>
                    <td>${item_p.nombre}</td>
                    <td>${item_p.apellido}</td>
                    <td>${item_p.cargo}</td>
                    <td>${item_p.direccion}</td>
                    <td>${item_p.telefono}</td>
                    <td><a class="btn btn-warning" href="MainControllerPersonal?op=editar&id=${item_p.id_p}">Editar</a></td>
                    <td><a class="btn btn-danger" href="MainControllerPersonal?op=eliminar&id=${item_p.id_p}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-success" href="inicio.jsp">Volver</a>
    </body>
</html>
