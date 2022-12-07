/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.modelo.Inmueble;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
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

/**
 *
 * @author Edson
 */
@WebServlet(name = "MainControllerInmueble", urlPatterns = {"/MainControllerInmueble"})
public class MainControllerInmueble extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "listi";
            ArrayList<Inmueble> lista_i = new ArrayList<Inmueble>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("listi")) {

                String sql = "SELECT * FROM inmuebles";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Inmueble inm = new Inmueble();
                    inm.setId_i(rs.getInt("id_i"));
                    inm.setNombre(rs.getString("nombre"));
                    inm.setCantidad(rs.getInt("cantidad"));
                    inm.setEstado(rs.getString("estado"));
                    System.out.println("Nombre = " + inm.getNombre());
                    lista_i.add(inm);
                }
                request.setAttribute("lista_i", lista_i);
                //redireciona a...->
                request.getRequestDispatcher("inmueble.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Inmueble inmu = new Inmueble();
                request.setAttribute("inmue", inmu);
                request.getRequestDispatcher("editarInmueble.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id_i = Integer.parseInt(request.getParameter("id_i"));
                String sql = "DELETE FROM inmuebles WHERE id_i = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_i);
                ps.executeUpdate();
                response.sendRedirect("MainControllerInmueble");
            }
            if (op.equals("editar")) {
                int id_i = Integer.parseInt(request.getParameter("id_i"));
                String sql = "SELECT * FROM inmuebles WHERE id_i = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_i);
                rs = ps.executeQuery();
                Inmueble i = new Inmueble();
                while (rs.next()) {
                    i.setId_i(rs.getInt("id_i"));
                    i.setNombre(rs.getString("nombre"));
                    i.setCantidad(rs.getInt("cantidad"));
                    i.setEstado(rs.getString("estado"));
                }
                request.setAttribute("inmue", i);
                request.getRequestDispatcher("editarInmueble.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_i = Integer.parseInt(request.getParameter("id_i"));
            String nombre = request.getParameter("nombre");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String estado = request.getParameter("estado");
            Inmueble in = new Inmueble();
            in.setNombre(nombre);
            in.setId_i(id_i);
            in.setCantidad(cantidad);
            in.setEstado(estado);
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            if (id_i == 0) {

                String sql = "INSERT INTO inmuebles(nombre,cantidad,estado) VALUES(?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, in.getNombre());
                ps.setInt(2, in.getCantidad());
                ps.setString(3, in.getEstado());
                ps.executeUpdate();
                response.sendRedirect("MainControllerInmueble");

            } else {
                try {
                    String sql = "UPDATE inmuebles set nombre = ?,cantidad = ?,estado = ? WHERE id_i = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, in.getNombre());
                    ps.setInt(2, in.getCantidad());
                    ps.setString(3, in.getEstado());
                    ps.setInt(4, in.getId_i());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error al actualizar " + e.getMessage());
                }
                response.sendRedirect("MainControllerInmueble");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN SQL" + ex.getMessage());
        }
    }

}
