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
    </head>
    <body>
        <h1>LOGIN</h1>
        <form action="MainControllerIniciar" method="post">
            <label>Correo</label>
            <input type="text" name="correo"><br>
            <label>Contraseña</label>
            <input type="text" name="password"><br>
            <input type="submit" value="Iniciar sesion">
        </form>

        <p><a href="MainController?op=nuevo">Registrarse</a></p>

        <!--<table border = 1>
            <tr>
                <th>Id</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
        
        
            <tr>
                <td>${item.id}</td>
                <td>${item.producto}</td>
                <td>${item.precio}</td>
                <td>${item.cantidad}</td>
                <td><a href="MainController?op=editar&id=${item.id_u}">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=${item.id_u}" onclick="return confirm('Eliminar ?')">Eliminar</a></td>
            </tr>
        
    </table>-->
        <c:forEach var="item" items="${lista}">

        </c:forEach>
    </body>
</html>
