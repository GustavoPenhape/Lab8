package com.example.laboratorio8.servlets;

import com.example.laboratorio8.model.beans.Heroe;
import com.example.laboratorio8.model.daos.DaoHeroe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HeroeServlet", urlPatterns = {"/HeroeServlet", ""})
public class HeroeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "listar" : action;
        RequestDispatcher requestDispatcher;
        DaoHeroe daoHeroe = new DaoHeroe();
        String heroeId;
        Heroe heroe;
        switch (action) {
            case "listar":
                request.setAttribute("lista", daoHeroe.lista());

                requestDispatcher = request.getRequestDispatcher("heroe/lista.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "crear":
                requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "borrar":
                heroeId = request.getParameter("id");
                daoHeroe.borrar(heroeId);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");

                break;
            case "editar":
                heroeId = request.getParameter("id");
                heroe = daoHeroe.buscarPorId(heroeId);

                if (heroe != null) { //abro el form para editar
                    request.setAttribute("heroe_send_jsp", heroe);
                    requestDispatcher = request.getRequestDispatcher("heroe/formEditar.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                }
                break;
            case "editarParcial":
                heroeId = request.getParameter("id");
                heroe = daoHeroe.buscarPorId(heroeId);

                if (heroe != null) { //abro el form para editar
                    request.setAttribute("heroeParcial", heroe);
                    requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        DaoHeroe daoHeroes = new DaoHeroe();

        switch (action) {
            case "guardar":

                //int minSalary = Integer.parseInt(minSalaryStr); //esto deben validar
                //String maxSalaryStr = request.getParameter("maxSalary");
                //int maxSalary = Integer.parseInt(maxSalaryStr); //falta validar
                String nombre = request.getParameter("nombre");
                String edad = request.getParameter("edad");
                String genero= request.getParameter("genero");
                String nivel = request.getParameter("nivel");
                String clase = request.getParameter("clase");
                String ataque = request.getParameter("ataque");
                String pareja = request.getParameter("pareja");
                String puntos_exp = request.getParameter("puntos_exp");

                Heroe heroes = new Heroe();
                heroes.setNombre(nombre);
                heroes.setEdad(Integer.parseInt(edad));
                heroes.setGenero(genero);
                heroes.setClase(clase);
                heroes.setNivel_inicial(Integer.parseInt(nivel));
                heroes.setAtaque(Integer.parseInt(ataque));
                heroes.setPuntos_experiencia(Integer.parseInt(puntos_exp));
                heroes.setPareja_id(Integer.parseInt(pareja));
                daoHeroes.guardarHeroes(heroes);
                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;
            case "actualizar":
                String IdHeroes = request.getParameter("IdHeroes");
                String nombre1 = request.getParameter("nombre");
                String edad1 = request.getParameter("edad");
                String genero1 = request.getParameter("genero");
                String nivel1 = request.getParameter("nivel");
                String clase1 = request.getParameter("clase");
                String ataque1 = request.getParameter("ataque");
                String pareja1 = request.getParameter("pareja");
                String puntos_exp1 = request.getParameter("puntos_exp");
//                try {
//                    int minSalary1 = Integer.parseInt(minSalaryStr1);
//                    int maxSalary1 = Integer.parseInt(maxSalaryStr1);
//                    daoJob.actualizar(jobId1, jobTitle1, minSalary1, maxSalary1);
//
//                    response.sendRedirect(request.getContextPath() + "/JobServlet");
//                } catch (NumberFormatException e) {
//                    response.sendRedirect(request.getContextPath() + "/JobServlet?action=editar&id=" + jobId1);
//                }

                daoHeroes.actualizarHeroes(IdHeroes,nombre1,edad1,genero1,nivel1,clase1,ataque1,pareja1,puntos_exp1);
                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;

            case "actualizarParcial":
                String idheroes2 = request.getParameter("id");
                String nombre2 = request.getParameter("nombre");
                String edad2 = request.getParameter("edad");
                String genero2 = request.getParameter("genero");
                String clase2 = request.getParameter("clase");
                //int minSalary2 = Integer.parseInt(minSalaryStr2);
                try {
                    daoHeroes.actualizarParcial(idheroes2,nombre2,edad2,genero2,clase2);
                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                } catch (SQLException e) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);

                    if (heroe1!= null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error","El texto no puede tener mas de 255 caractéres");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                }


        }
    }
}
