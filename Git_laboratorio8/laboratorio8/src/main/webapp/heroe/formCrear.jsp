<%--
  Created by IntelliJ IDEA.
  User: stuar
  Date: 27/10/22
  Time: 10:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String errorCrear1 = (String) request.getAttribute("errorCrear1");%>
<% String errorCrear2 = (String) request.getAttribute("errorCrear2");%>
<% String errorCrear3 = (String) request.getAttribute("errorCrear3");%>
<% String errorCrear4 = (String) request.getAttribute("errorCrear4");%>
<% String errorCrear5 = (String) request.getAttribute("errorCrear5");%>
<% String errorCrear6 = (String) request.getAttribute("errorCrear6");%>

<html>
  <head>
    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Crear HEROES</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">
    </head>
  <body>
    <div class='container'>
      <div class="row justify-content-center">
        <div class="col-md-6 col-sm-12 col-lg-4">
          <h1>Crear Héroe</h1>
          <form method="post" action="<%=request.getContextPath()%>/HeroeServlet?action=guardar">
            <div class="mb-3">
              <label for="nombre" class="form-label">Nombre del Heroe</label>
              <input type="text" class="form-control  <%=errorCrear1!=null?"is-invalid":""%>" id="nombre" required placeholder="Nombre" name="nombre">
              <% if (errorCrear1 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear1%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="edad" class="form-label">Edad del Heroe</label>
              <input type="text" class="form-control <%=errorCrear2!=null?"is-invalid":""%>" id="edad" required placeholder="Edad" name="edad">
              <% if (errorCrear2 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear2%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="genero" class="form-label">Genero</label>
              <input type="text" class="form-control <%=errorCrear3!=null?"is-invalid":""%>" id="genero" required placeholder="Genero" name="genero">
              <% if (errorCrear3 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear3%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="clase" class="form-label">Clase del heroe</label>
              <input type="text" class="form-control <%=errorCrear4!=null?"is-invalid":""%>" id="clase" required placeholder="Clase" name="clase">
              <% if (errorCrear4 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear4%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="nivel" class="form-label">Nivel del heroe</label>
              <input type="text" class="form-control <%=errorCrear5!=null?"is-invalid":""%>" id="nivel" required placeholder="Nivel" name="nivel">
              <% if (errorCrear5 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear5%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="ataque" class="form-label">Ataque del Heroe</label>
              <input type="text" class="form-control <%=errorCrear6!=null?"is-invalid":""%>" id="ataque" required placeholder="Ataque" name="ataque">
              <% if (errorCrear6 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=errorCrear6%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="pareja" class="form-label">Pareja del heroe</label>
              <input type="text" class="form-control" id="pareja" required placeholder="Nivel" name="pareja">
            </div>
            <div class="mb-3">
              <label for="puntos_exp" class="form-label">Points</label>
              <input type="text" class="form-control" id="puntos_exp" placeholder="puntitos" name="puntos_exp">
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="<%=request.getContextPath()%>/HeroeServlet" class="btn btn-danger">Regresar</a>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
