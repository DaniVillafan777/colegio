<%@page import="com.emergentes.modelo.Alumno"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Usuario"%>


<%
    Alumno alumn = (Alumno) request.getAttribute("alumn");

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
            <c:if test="${alumn.id_alum == 0}">Registro</c:if>
            <c:if test="${alumn.id_alum != 0}">Editar Alumno</c:if>
            </h1>
            <form action="MainControllerAlumno" method="post">
                <input type="hidden" name="id_alum" value="${alumn.id_alum}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input class="form-control" type="text" name="nombre" value="${alumn.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input class="form-control" type="text" name="apellido" value="${alumn.apellido}"></td>
                </tr>
                <tr>
                    <td>C.I</td>
                    <td><input class="form-control" type="text" name="ci" value="${alumn.ci}"></td>
                </tr>
                <tr>
                    <td>Rude</td>
                    <td><input class="form-control" type="number" name="rude" value="${alumn.rude}"></td>
                </tr>
                <tr>
                    <td>Curso</td>
                    <td><input class="form-control" type="text" name="curso" value="${alumn.curso}"></td>
                </tr>
                <tr>
                    <td>Grado</td>
                    <td><input class="form-control" type="text" name="grado" value="${alumn.grado}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-success" type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
