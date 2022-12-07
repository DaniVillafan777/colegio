/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.modelo.Alumno;
import com.emergentes.modelo.Personal;
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

/**
 *
 * @author Edson
 */
@WebServlet(name = "MainControllerAlumno", urlPatterns = {"/MainControllerAlumno"})
public class MainControllerAlumno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "lista";
            ArrayList<Alumno> lista_a = new ArrayList<Alumno>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("lista")) {

                String sql = "SELECT * FROM alumnos";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Alumno alu = new Alumno();
                    alu.setId_alum(rs.getInt("id_alum"));
                    alu.setNombre(rs.getString("nombre"));
                    alu.setApellido(rs.getString("apellido"));
                    alu.setCi(rs.getInt("ci"));
                    alu.setRude(rs.getInt("rude"));
                    alu.setCurso(rs.getInt("curso"));
                    alu.setGrado(rs.getString("grado"));
                    System.out.println("Nombre = " + alu.getNombre());
                    lista_a.add(alu);
                }
                request.setAttribute("lista_a", lista_a);
                //redireciona a...->
                request.getRequestDispatcher("alumno.jsp").forward(request, response);

            }
            if (op.equals("nuevo")) {
                Alumno alumn = new Alumno();
                request.setAttribute("alumn", alumn);
                request.getRequestDispatcher("editarAlumno.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id_p = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM alumnos WHERE id_alum = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_p);
                ps.executeUpdate();
                response.sendRedirect("MainControllerAlumno");
            }
            if (op.equals("editar")) {
                int id_p = Integer.parseInt(request.getParameter("id"));
                System.out.println("ID = " + id_p);
                String sql = "SELECT * FROM alumnos WHERE id_alum = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_p);
                rs = ps.executeQuery();
                Alumno a = new Alumno();
                while (rs.next()) {
                    a.setId_alum(rs.getInt("id_alum"));
                    a.setNombre(rs.getString("nombre"));
                    a.setApellido(rs.getString("apellido"));
                    a.setCi(rs.getInt("ci"));
                    a.setRude(rs.getInt("rude"));
                    a.setCurso(rs.getInt("curso"));
                    a.setGrado(rs.getString("grado"));
                }
                request.setAttribute("alumn", a);
                request.getRequestDispatcher("editarAlumno.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_alum = Integer.parseInt(request.getParameter("id_alum"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int ci = Integer.parseInt(request.getParameter("ci"));
            int rude = Integer.parseInt(request.getParameter("rude"));
            int curso = Integer.parseInt(request.getParameter("curso"));
            String grado = request.getParameter("grado");
            Alumno al = new Alumno();
            al.setNombre(nombre);
            al.setId_alum(id_alum);
            al.setApellido(apellido);
            al.setCi(ci);
            al.setRude(rude);
            al.setCurso(curso);
            al.setGrado(grado);
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            if (id_alum == 0) {

                String sql = "INSERT INTO alumnos(nombre,apellido,ci,rude,curso,grado) VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, al.getNombre());
                ps.setString(2, al.getApellido());
                ps.setInt(3, al.getCi());
                ps.setInt(4, al.getRude());
                ps.setInt(5, al.getCurso());
                ps.setString(6, al.getGrado());
                ps.executeUpdate();
                response.sendRedirect("MainControllerAlumno");

            } else {
                try {
                    String sql = "UPDATE alumnos set nombre = ?,apellido = ?,ci = ?,rude = ?,curso = ?,grado = ? WHERE id_alum = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, al.getNombre());
                    ps.setString(2, al.getApellido());
                    ps.setInt(3, al.getCi());
                    ps.setInt(4, al.getRude());
                    ps.setInt(5, al.getCurso());
                    ps.setString(6, al.getGrado());
                    ps.setInt(7, al.getId_alum());
                    ps.executeUpdate();
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error al actualizar " + e.getMessage());
                }
                response.sendRedirect("MainControllerAlumno");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN SQL" + ex.getMessage());
        }
    }

}
