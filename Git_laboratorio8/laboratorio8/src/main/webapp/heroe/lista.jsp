
<%@ page import="com.example.laboratorio8.model.beans.Heroe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" scope="request" type="java.util.ArrayList<com.example.laboratorio8.model.beans.Heroe>"/>
<%
  String searchText = (String) request.getAttribute("searchText");
%>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista trabajos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  </head>
  <body>
    <div class='container'>
      <h1 class='mb-3'>Lista de Heroes </h1>
      <a href="<%=request.getContextPath()%>/HeroeServlet?action=crear" class="btn btn-success">Crear Heroe</a>
      <div class="row align-items-center">
        <div class="col-10">
          <form class="mt-2" method="post" action="<%=request.getContextPath()%>/HeroeServlet?action=buscar">
            <div class="form-floating mb-3">
              <input type="text" name="searchText" class="form-control" id="floatingInput"
                     placeholder="Buscar Heroe" value="<%=searchText!=null?searchText:""%>">
              <label for="floatingInput">Buscar Heroe</label>
            </div>
          </form>
        </div>
        <div class="col-2">
          <a href="<%=request.getContextPath()%>/HeroeServlet" class="btn btn-secondary">borrar</a>
        </div>
      </div>
      <table class="table">
        <tr>
          <th>Heroe ID</th>
          <th>nombre</th>
          <th>edad</th>
          <th>genero</th>
          <th>nivel</th>
          <th>ataque</th>
          <th>Puntos de Experiencia</th>
          <th>Experiencia</th>
          <th>ID de Pareja</th>
          <th></th>
          <th></th>
        </tr>
        <% for (Heroe heroe : lista) { %>
        <tr>
          <td><%=heroe.getHeroeId()%>
          </td>
          <td><%=heroe.getNombre()%>
          </td>
          <td><%=heroe.getEdad()%>
          </td>
          <td><%=heroe.getGenero()%>
          </td>
          <td><%=heroe.getNivel_inicial()%>
          </td>
          <td><%=heroe.getAtaque()%>
          </td>
          <td><%=heroe.getPuntos_experiencia()%>
          </td>
          <td><%=heroe.getExperiencia()%>
          </td>
          <td><%=heroe.getPareja_id()%>
          </td>
          <td>
            <a type="button" class="btn btn-primary"
               href="<%=request.getContextPath()%>/HeroeServlet?action=editarParcial&id=<%=heroe.getHeroeId()%>">
              <i class="bi bi-pencil-square"></i>
            </a>
          </td>
          <td>
            <a type="button" class="btn btn-danger"
               onclick="return confirm('¿Estas seguro(a) que deseas borrar?')"
               href="<%=request.getContextPath()%>/HeroeServlet?action=borrar&id=<%=heroe.getHeroeId()%>">
              <i class="bi bi-trash"></i>
            </a>
          </td>
        </tr>
        <% } %>
      </table>
    </div>
  </body>
</html>

