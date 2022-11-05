
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
      <h1 class='mb-3'>Lista de Heroes en hr</h1>
      <a href="<%=request.getContextPath()%>/HeroeServlet?action=crear" class="btn btn-success">Crear Heroe</a>
      <div class="row align-items-center">
        <div class="col-10">
          <form class="mt-2" method="post" action="<%=request.getContextPath()%>/HeroeServlet?action=buscar">
            <div class="form-floating mb-3">
              <input type="text" name="searchText" class="form-control" id="floatingInput"
                     placeholder="Buscar trabajo" value="<%=searchText!=null?searchText:""%>">
              <label for="floatingInput">Buscar trabajo</label>
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
          <th></th>
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
          <td>
            <a type="button" class="btn btn-primary"
               href="<%=request.getContextPath()%>/HeroeServlet?action=editar&id=<%=heroe.getHeroeId()%>">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                   class="bi bi-pencil" viewBox="0 0 16 16">
                <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"></path>
              </svg>
            </a>
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

  </body>
</html>
