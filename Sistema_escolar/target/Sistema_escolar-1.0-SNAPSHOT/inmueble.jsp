<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Inmueble"%>

<%
    List<Inmueble> lista_i = (List<Inmueble>) request.getAttribute("lista_i");

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
        <h1>Lista de Inmueble</h1>

        <p><a class="btn btn-primary" href="MainControllerInmueble?op=nuevo">Nuevo</a></p>
        <table class="table table-striped" border = 1>
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Cantidad</th>
                <th>Estado</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="item_i" items="${lista_i}">
                <tr>
                    <td>${item_i.id_i}</td>
                    <td>${item_i.nombre}</td>
                    <td>${item_i.cantidad}</td>
                    <td>${item_i.estado}</td>
                    <td><a class="btn btn-warning" href="MainControllerInmueble?op=editar&id_i=${item_i.id_i}">Editar</a></td>
                    <td><a class="btn btn-danger" href="MainControllerInmueble?op=eliminar&id_i=${item_i.id_i}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-success" href="inicio.jsp">Volver</a>
    </body>
</html>
