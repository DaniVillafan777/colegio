<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Personal"%>
<%
    List<Personal> lista_p = (List<Personal>)request.getAttribute("lista_p");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema escolar</title>
    </head>
    <body>
        <h1>Lista de personal</h1>

        <p><a href="MainControllerPersonal?op=nuevo">Nuevo</a></p>
        <table border = 1>
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
                    <td><a href="MainControllerPersonal?op=editar&id=${item.id_p}">Editar</a></td>
                    <td><a href="MainControllerPersonal?op=eliminar&id=${item.id_p}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
