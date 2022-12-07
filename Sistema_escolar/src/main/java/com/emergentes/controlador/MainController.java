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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("list")) {

                String sql = "SELECT * FROM usuario";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario usu = new Usuario();
                    usu.setId_u(rs.getInt("id_u"));
                    usu.setNombres(rs.getString("nombres"));
                    usu.setApellidos(rs.getString("apellidos"));
                    usu.setCorreo(rs.getString("correo"));
                    usu.setPass(rs.getString("pass"));
                    lista.add(usu);
                }
                request.setAttribute("lista", lista);
                //redireciona a...->
                request.getRequestDispatcher("usuario.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Usuario usua = new Usuario();
                request.setAttribute("usua", usua);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id_u = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM usuario WHERE id_u = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_u);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            }
            if (op.equals("editar")) {
                int id_u = Integer.parseInt(request.getParameter("id"));
                String sql = "SELECT * FROM usuario WHERE id_u = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_u);
                rs = ps.executeQuery();
                Usuario u = new Usuario();
                while (rs.next()) {
                    u.setId_u(rs.getInt("id_u"));
                    u.setNombres(rs.getString("nombres"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setCorreo(rs.getString("correo"));
                    u.setPass(rs.getString("pass"));
                }
                request.setAttribute("usua", u);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

            }
            if (op.equals("iniciar")) {


            }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_u = Integer.parseInt(request.getParameter("id_u"));
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            Usuario us = new Usuario();
            us.setNombres(nombres);
            us.setId_u(id_u);
            us.setApellidos(apellidos);
            us.setCorreo(correo);
            us.setPass(pass);
            
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            if (id_u == 0) {

                String sql = "INSERT INTO usuario(nombres,apellidos,correo,pass) VALUES(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, us.getNombres());
                ps.setString(2, us.getApellidos());
                ps.setString(3, us.getCorreo());
                ps.setString(4, Cifrar_contraseña.md5(us.getPass()));
                ps.executeUpdate();
                response.sendRedirect("MainController");

            } else {
                try {
                    String sql = "UPDATE usuario set nombres = ?,apellidos = ?,correo = ?,pass = ? WHERE id_u = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, us.getNombres());
                    ps.setString(2, us.getApellidos());
                    ps.setString(3, us.getCorreo());
                    ps.setString(4, Cifrar_contraseña.md5(us.getPass()));
                    ps.setInt(5, us.getId_u());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error al actualizar " + e.getMessage());
                }
                response.sendRedirect("MainController");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN SQL" + ex.getMessage());
        }
    }

}
