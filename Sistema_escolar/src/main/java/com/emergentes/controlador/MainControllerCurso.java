package com.emergentes.controlador;

import com.emergentes.modelo.Curso;
import com.emergentes.modelo.Personal;
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
@WebServlet(name = "MainControllerCurso", urlPatterns = {"/MainControllerCurso"})
public class MainControllerCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "listcu";
            ArrayList<Curso> lista_cu = new ArrayList<Curso>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("listcu")) {

                String sql = "SELECT * FROM curso";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Curso cur = new Curso();
                    cur.setId_cu(rs.getInt("id_cu"));
                    cur.setGrado(rs.getString("grado"));
                    cur.setNum_aula(rs.getInt("num_aula"));
                    cur.setId_inmueble(rs.getInt("id_inmueble"));
                    lista_cu.add(cur);
                }
                request.setAttribute("lista_cu", lista_cu);
                //redireciona a...->
                request.getRequestDispatcher("curso.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Curso curs = new Curso();
                request.setAttribute("curso", curs);
                request.getRequestDispatcher("editarCurso.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id_cu = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM curso WHERE id_cu = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_cu);
                ps.executeUpdate();
                response.sendRedirect("MainControllerCurso");
            }
            if (op.equals("editar")) {
                int id_cu = Integer.parseInt(request.getParameter("id"));
                String sql = "SELECT * FROM curso WHERE id_cu = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_cu);
                rs = ps.executeQuery();
                Curso c = new Curso();
                while (rs.next()) {
                    c.setId_cu(rs.getInt("id_cu"));
                    c.setGrado(rs.getString("nombre"));

                }
                request.setAttribute("perso", c);
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
