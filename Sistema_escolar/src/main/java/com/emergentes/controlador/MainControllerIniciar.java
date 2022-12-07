/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.modelo.Cifrar_contraseña;
import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edson
 */
@WebServlet(name = "MainControllerIniciar", urlPatterns = {"/MainControllerIniciar"})
public class MainControllerIniciar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            String usuario = request.getParameter("correo");
            String contraseña = Cifrar_contraseña.md5(request.getParameter("password"));
            String sql = "SELECT * FROM usuario WHERE pass = ? AND correo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, contraseña);
            ps.setString(2, usuario);
            rs = ps.executeQuery();
            Usuario u = new Usuario();
            if (rs.next() == false) {
                System.out.println("Datos incorrectos");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                while (rs.next()) {
                    u.setId_u(rs.getInt("id_u"));
                    u.setNombres(rs.getString("nombres"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setCorreo(rs.getString("correo"));
                }
                request.setAttribute("usua", u);
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControllerIniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
