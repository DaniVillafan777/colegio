/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.modelo.Personal;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Edson
 */
@WebServlet(name = "MainControllerPersonal", urlPatterns = {"/MainControllerPersonal"})
public class MainControllerPersonal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "listp";
            ArrayList<Personal> lista_p = new ArrayList<Personal>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("listp")) {

                String sql = "SELECT * FROM personal";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Personal per = new Personal();
                    per.setId_p(rs.getInt("id_p"));
                    per.setNombre(rs.getString("nombre"));
                    per.setApellido(rs.getString("apellido"));
                    per.setCargo(rs.getString("cargo"));
                    per.setDireccion(rs.getString("direccion"));
                    per.setTelefono(rs.getInt("telefono"));
                    System.out.println("Nombre = "+per.getNombre());
                    lista_p.add(per);
                }
                request.setAttribute("lista_p", lista_p);
                System.out.println("Si entro por list");
                System.out.println("Nombres de la lista = "+lista_p.toString());
                //redireciona a...->
                request.getRequestDispatcher("personal.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Personal pers = new Personal();
                request.setAttribute("perso", pers);
                request.getRequestDispatcher("editarPersonal.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id_p = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM personal WHERE id_p = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_p);
                ps.executeUpdate();
                response.sendRedirect("MainControllerPersonal");
            }
            if (op.equals("editar")) {
                int id_p = Integer.parseInt(request.getParameter("id"));
                System.out.println("ID = "+id_p);
                String sql = "SELECT * FROM personal WHERE id_p = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_p);
                rs = ps.executeQuery();
                Personal p = new Personal();
                while (rs.next()) {
                    p.setId_p(rs.getInt("id_p"));
                    p.setNombre(rs.getString("nombre"));
                    p.setApellido(rs.getString("apellido"));
                    p.setCargo(rs.getString("cargo"));
                    p.setDireccion(rs.getString("direccion"));
                    p.setTelefono(rs.getInt("telefono"));
                }
                request.setAttribute("perso", p);
                request.getRequestDispatcher("editarPersonal.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_p = Integer.parseInt(request.getParameter("id_p"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String cargo = request.getParameter("cargo");
            String direccion = request.getParameter("direccion");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            Personal pe = new Personal();
            pe.setNombre(nombre);
            pe.setId_p(id_p);
            pe.setApellido(apellido);
            pe.setCargo(cargo);
            pe.setDireccion(direccion);
            pe.setTelefono(telefono);
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            if (id_p == 0) {

                String sql = "INSERT INTO personal(nombre,apellido,cargo,direccion,telefono) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, pe.getNombre());
                ps.setString(2, pe.getApellido());
                ps.setString(3, pe.getCargo());
                ps.setString(4, pe.getDireccion());
                ps.setInt(5, pe.getTelefono());
                ps.executeUpdate();
                response.sendRedirect("MainControllerPersonal");

            } else {
                try {
                    String sql = "UPDATE personal set nombre = ?,apellido = ?,cargo = ?,direccion = ?,telefono = ? WHERE id_p = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, pe.getNombre());
                    ps.setString(2, pe.getApellido());
                    ps.setString(3, pe.getCargo());
                    ps.setString(4, pe.getDireccion());
                    ps.setInt(5, pe.getTelefono());
                    ps.setInt(6, pe.getId_p());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error al actualizar " + e.getMessage());
                }
                response.sendRedirect("MainControllerPersonal");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN SQL" + ex.getMessage());
        }
    }


}
