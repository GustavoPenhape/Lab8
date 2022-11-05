package com.example.laboratorio8.servlets;

import com.example.laboratorio8.model.beans.Heroe;
import com.example.laboratorio8.model.daos.DaoHeroe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HeroeServlet", urlPatterns = {"/HeroeServlet",""})
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
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
