package com.example.laboratorio8.servlets;

import com.example.laboratorio8.model.beans.Heroe;
import com.example.laboratorio8.model.daos.DaoHeroe;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLWarning;


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

            case "editarParcial":
                //se le asigna un idHero a heroeID
                heroeId = request.getParameter("id");
                //se busca a dicho heroe por ese ID mediante buscarporID q devuelve un heroe
                heroe = daoHeroe.buscarPorId(heroeId);

                //Si este heroe existe ( no null ) entonces se le envia un heroe PARCIAL  como nombre pero q es un heroe a setAttribute
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
                String genero = request.getParameter("genero");
                String nivel = request.getParameter("nivel");
                String clase = request.getParameter("clase");
                String ataque = request.getParameter("ataque");
                String pareja = request.getParameter("pareja");
                String puntos_exp = request.getParameter("puntos_exp");

                if (nombre.length() > 11) {
                    request.setAttribute("errorCrear1", "El texto no puede tener mas de 10 caracteres");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);

                } else if (Integer.parseInt(edad) < 8 || Integer.parseInt(edad) > 999) {
                    request.setAttribute("error2", "La edad no está en el rango [8;999]");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);
                } else if (!((genero.equalsIgnoreCase("M")) || (genero.equalsIgnoreCase("F")) ||
                        (genero.equalsIgnoreCase("O")) || (genero.equalsIgnoreCase("-")))) {
                    request.setAttribute("error3", "Debe digitar: M, F u O .");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);
                } else if (ContainsNumberAndLengthIsAbovefifty(clase)) {
                    request.setAttribute("error4", "LA CLASE NO DEBE CONTENER CARACTERES NUMÉRICOS" +
                            " O SOBREPASA LOS 50 CARACTERES.");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);
                } else if (Integer.parseInt(nivel) < 1 || Integer.parseInt(nivel) > 100) {//  y sea mayor a 50
                    request.setAttribute("error5", "EL NIVEL NO ESTÁ EN EL RANGO [1;100]");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);
                } else if (Integer.parseInt(ataque) < 1) {
                    request.setAttribute("error6", "EL ATAQUE DEBE SER MAYOR A 0");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formCrear.jsp");
                    requestDispatcher.forward(request, response);
                }

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

                daoHeroes.actualizarHeroes(IdHeroes, nombre1, edad1, genero1, nivel1, clase1, ataque1, pareja1, puntos_exp1);
                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;

            case "actualizarParcial":
                String idheroes2 = request.getParameter("id");
                String nombre2 = request.getParameter("nombre");
                String edad2 = request.getParameter("edad");
                String genero2 = request.getParameter("genero");
                String clase2 = request.getParameter("clase");
                String nivel2 = request.getParameter("nivel_inicial");
                String ataque2 = request.getParameter("ataque");
                String pareja2 = request.getParameter("pareja");

                if (nombre2.length() > 11) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error", "El texto no puede tener mas de 10 caracteres");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (Integer.parseInt(edad2) < 8 || Integer.parseInt(edad2) > 999) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error2", "La edad no está en el rango [8;999]");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (!((genero2.equalsIgnoreCase("M")) || (genero2.equalsIgnoreCase("F")) ||
                        (genero2.equalsIgnoreCase("O")) || (genero2.equalsIgnoreCase("-")))) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error3", "Debe digitar: M, F u O .");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (ContainsNumberAndLengthIsAbovefifty(clase2)) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error4", "LA CLASE NO DEBE CONTENER CARACTERES NUMÉRICOS" +
                                " O SOBREPASA LOS 50 CARACTERES.");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (Integer.parseInt(nivel2) < 1 || Integer.parseInt(nivel2) > 100) {//  y sea mayor a 50
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error5", "EL NIVEL NO ESTÁ EN EL RANGO [1;100]");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (Integer.parseInt(ataque2) < 1) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error6", "EL ATAQUE DEBE SER MAYOR A 0");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else if (pareja2.equalsIgnoreCase("0")) {
                    try {
                        daoHeroes.actualizarParcial(idheroes2, nombre2, edad2, genero2, clase2, nivel2, ataque2, pareja2);
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    } catch (SQLException e) {
                        Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                        if (heroe1 != null) { //abro el form para editar
                            request.setAttribute("heroeParcial", heroe1);
                            request.setAttribute("error", "Ocurrio un error en actualizar heroes");
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                            requestDispatcher.forward(request, response);
                        } else { //id no encontrado
                            response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                        }
                    }
                } else if (!(isNumeric(pareja2)) || (daoHeroes.buscarPorId(pareja2).getPareja_id()) != 0 || pareja2.equalsIgnoreCase(idheroes2)) {
                    Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                    if (heroe1 != null) { //abro el form para editar
                        request.setAttribute("heroeParcial", heroe1);
                        request.setAttribute("error7", "o EL ID no existe.");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    }
                } else {
                    try {
                        daoHeroes.actualizarParcial(idheroes2, nombre2, edad2, genero2, clase2, nivel2, ataque2, pareja2);
                        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    } catch (SQLException e) {
                        Heroe heroe1 = daoHeroes.buscarPorId(idheroes2);
                        if (heroe1 != null) { //abro el form para editar
                            request.setAttribute("heroeParcial", heroe1);
                            request.setAttribute("error", "Ocurrio un error en actualizar heroes");
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                            requestDispatcher.forward(request, response);
                        } else { //id no encontrado
                            response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                        }
                    }
                }
                break;
        }
    }

    public static boolean ContainsNumberAndLengthIsAbovefifty(String strNum) {
        boolean value = true;
        if (strNum.length() < 50 && strNum.length() > 0) {
            char[] chars = strNum.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return value;
        }
    }

    private static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}

