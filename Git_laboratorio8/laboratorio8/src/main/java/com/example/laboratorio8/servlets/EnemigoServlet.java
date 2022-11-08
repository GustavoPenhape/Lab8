package com.example.laboratorio8.servlets;

import com.example.laboratorio8.model.beans.Enemigo;
import com.example.laboratorio8.model.beans.Heroe;
import com.example.laboratorio8.model.daos.DaoEnemigo;

import com.example.laboratorio8.model.daos.DaoHeroe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EnemigoServlet", urlPatterns = {"/EnemigoServlet", ""})
public class EnemigoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "listar" : action;
        RequestDispatcher requestDispatcher;
        DaoEnemigo daoEnemigo = new DaoEnemigo();
        String enemigoId;
        Enemigo enemigo;
        switch (action) {
            case "listar":
                request.setAttribute("lista", daoEnemigo.lista());

                requestDispatcher = request.getRequestDispatcher("enemigo/lista.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "borrar":
                enemigoId = request.getParameter("id");
                daoEnemigo.borrar(enemigoId);

                response.sendRedirect(request.getContextPath() + "/EnemigoServlet");

                break;

            case "editarParcial":
                //se le asigna un idEnemigo a enemigoID
                enemigoId = request.getParameter("id");
                //se busca a dicho enemigo por ese ID mediante buscarporID q devuelve un enemigo
                enemigo = daoEnemigo.buscarPorId(enemigoId);

                //Si este enemigo existe ( no null ) entonces se le envia un enemigo PARCIAL  como nombre pero q es un enemigo a setAttribute
                if (enemigo != null) { //abro el form para editar
                    request.setAttribute("enemigoParcial", enemigo);
                    requestDispatcher = request.getRequestDispatcher("enemigo/formEditarParcial.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                }
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        DaoEnemigo daoEnemigo = new DaoEnemigo();

        switch (action) {
            case "guardar":
                String nombre = request.getParameter("nombre");
                String ataque = request.getParameter("edad");
                String experienciaEntregada = request.getParameter("experienciaEntregada");
                String probabilidadTirarObjeto = request.getParameter("probabilidadTirarObjeto");
                String genero = request.getParameter("genero");
                String objetoEntregado = request.getParameter("objetoEntregado");
                String clase = request.getParameter("clase");

                Enemigo enemigo = new Enemigo();
                enemigo.setNombreEnemigo(nombre);
                enemigo.setAtaque(Integer.parseInt(ataque));
                enemigo.setExperienciaEntregada(Integer.parseInt(experienciaEntregada));
                enemigo.setProbabilidadTirarObjeto(Integer.parseInt(probabilidadTirarObjeto));
                enemigo.setGenero(genero);
                enemigo.setObjetoEntregado(objetoEntregado);
                enemigo.setClase(Integer.parseInt(clase));

                daoEnemigo.guardarEnemigos(enemigo);
                response.sendRedirect(request.getContextPath() + "/EnemigoServlet");

            case "actualizarParcial":
                String idenemigo = request.getParameter("idenemigo");
                String nombre1 = request.getParameter("nombre1");
                String ataque1 = request.getParameter("ataque1");
                String experienciaEntregada1 = request.getParameter("experienciaEntregada1");
                String probabilidadTirarObjeto1 = request.getParameter("probabilidadTirarObjeto1");
                String genero1 = request.getParameter("genero1");
                String objetoEntregado1 = request.getParameter("objetoEntregado1");
                String clase1 = request.getParameter("clase1");

                int idenemigo2= Integer.parseInt(idenemigo);
                int ataque2= Integer.parseInt(ataque1);
                int experienciaEntregada2= Integer.parseInt(experienciaEntregada1);
                int probabilidadTirarObjeto2= Integer.parseInt(probabilidadTirarObjeto1);
                int clase2= Integer.parseInt(clase1);


                if (clase1 != "Dragon" || clase1 != "Fantasma" || clase1 != "Demonio" || clase1 != "Pez" || clase1 != "Humano" || clase1 != "Bestia" || clase1 != "Ave" || clase1 != "Otros" ) {
                    Enemigo enemigo1 = daoEnemigo.buscarPorId(idenemigo);
                    if (enemigo1 != null) { //abro el form para editar
                        request.setAttribute("enemigoParcial", enemigo1);
                        request.setAttribute("error2", "La clase ingresada no es válida");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("enemigo/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                    }

                } else if (clase1 != "Fuego" || clase1 != "Tierra" || clase1 != "Agua" || clase1 != "Viento" || clase1 != "Void") {
                    Enemigo enemigo1 = daoEnemigo.buscarPorId(idenemigo);
                    if (enemigo1 != null) { //abro el form para editar
                        request.setAttribute("enemigoParcial", enemigo1);
                        request.setAttribute("error3", "EL tipo de elemento ingresado no es válido");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("enemigo/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                    }

                } else if (!((genero1.equalsIgnoreCase("M")) || (genero1.equalsIgnoreCase("F")) ||
                        (genero1.equalsIgnoreCase("O")) || (genero1.equalsIgnoreCase("-")))) {
                    Enemigo enemigo1 = daoEnemigo.buscarPorId(idenemigo);
                    if (enemigo1 != null) { //abro el form para editar
                        request.setAttribute("enemigoParcial", enemigo1);
                        request.setAttribute("error3", "Debe digitar: M, F u O .");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("enemigo/formEditarParcial.jsp");
                        requestDispatcher.forward(request, response);
                    } else { //id no encontrado
                        response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                    }

                } else {
                    try{
                        daoEnemigo.actualizarParcial(idenemigo2, nombre1, ataque2, experienciaEntregada2, probabilidadTirarObjeto2, genero1, objetoEntregado1, clase2);
                        response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                    } catch (NumberFormatException e) {
                        Enemigo enemigo1 = daoEnemigo.buscarPorId(idenemigo);
                        if (enemigo1 != null) { //abro el form para editar
                            request.setAttribute("enemigoParcial", enemigo1);
                            request.setAttribute("error", "Ocurrio un error en actualizar heroes");
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("enemigo/formEditarParcial.jsp");
                            requestDispatcher.forward(request, response);
                        } else { //id no encontrado
                            response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                        }
                    }
                    //try {
                    //    daoEnemigo.actualizarParcial(idheroes2, nombre2, edad2, genero2, clase2);
                    //    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    //} catch (SQLException e) {
                    //    Heroe heroe1 = daoHeroes.buscarPorId(idenemigo);
                    //    if (heroe1 != null) { //abro el form para editar
                    //        request.setAttribute("heroeParcial", heroe1);
                    //        request.setAttribute("error", "Ocurrio un error en actualizar heroes");
                    //        RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroe/formEditarParcial.jsp");
                    //        requestDispatcher.forward(request, response);
                    //    } else { //id no encontrado
                    //        response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                    //    }
                    //}
                }
                break;
        }
    }
}
