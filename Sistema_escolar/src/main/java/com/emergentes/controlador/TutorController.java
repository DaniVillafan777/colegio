package com.emergentes.controlador;

import com.emergentes.modelo.Tutor;
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

@WebServlet(name = "TutorController", urlPatterns = {"/TutorController"})
public class TutorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<Tutor> lista = new ArrayList<Tutor>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("list")) {

                String sql = "SELECT * FROM tutor";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Tutor tut = new Tutor();
                    tut.setId(rs.getInt("id_t"));
                    tut.setNombre(rs.getString("nombre"));
                    tut.setApellido(rs.getString("apellido"));
                    tut.setDireccion(rs.getString("direccion"));
                    tut.setTelefono(rs.getInt("telefono"));
                    lista.add(tut);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("indextutor.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Tutor tut = new Tutor();
                request.setAttribute("tut", tut);
                request.getRequestDispatcher("editartutor.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM tutor WHERE id_t = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("TutorController");
            }
            if (op.equals("editar")) {
                System.out.println("");
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "SELECT * FROM tutor WHERE id_t = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                Tutor tut = new Tutor();
                while (rs.next()) {
                    tut.setId(rs.getInt("id_t"));
                    tut.setNombre(rs.getString("nombre"));
                    tut.setApellido(rs.getString("apellido"));
                    tut.setDireccion(rs.getString("direccion"));
                    tut.setTelefono(rs.getInt("telefono"));
                }
                request.setAttribute("tut", tut);
                request.getRequestDispatcher("editartutor.jsp").forward(request, response);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            int id = Integer.parseInt(request.getParameter("id_t"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            int telefon = Integer.parseInt(request.getParameter("telefono"));
            Tutor t = new Tutor();
            t.setNombre(nombre);
            t.setId(id);
            t.setApellido(apellido);
            t.setDireccion(direccion);
            t.setTelefono(telefon);
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            if (id == 0) {

                String sql = "INSERT INTO tutor(nombre,apellido,direccion,telefono) VALUES(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getNombre());
                ps.setString(2, t.getApellido());
                ps.setString(3, t.getDireccion());
                ps.setInt(4, t.getTelefono());
                ps.executeUpdate();
                response.sendRedirect("TutorController");
            } else {
                try {
                    String sql = "UPDATE tutor set nombre = ?,apellido = ?,direccion = ?,telefono = ? WHERE id_t = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, t.getNombre());
                    ps.setString(2, t.getApellido());
                    ps.setString(3, t.getDireccion());
                    ps.setInt(4, t.getTelefono());
                    ps.setInt(5, t.getId());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error al actualizar " + e.getMessage());
                }
                response.sendRedirect("TutorController");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN SQL" + ex.getMessage());
        }
    }
}
