<%--
  Created by IntelliJ IDEA.
  User: stuar
  Date: 27/10/22
  Time: 10:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Crear trabajos</title>
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
              <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
            </div>
            <div class="mb-3">
              <label for="edad" class="form-label">Edad del Heroe</label>
              <input type="text" class="form-control" id="edad" placeholder="Edad" name="edad">
            </div>
            <div class="mb-3">
              <label for="genero" class="form-label">Genero</label>
              <input type="text" class="form-control" id="genero" placeholder="Genero" name="genero">
            </div>
            <div class="mb-3">
              <label for="clase" class="form-label">Clase del heroe</label>
              <input type="text" class="form-control" id="clase" placeholder="Clase" name="clase">
            </div>
            <div class="mb-3">
              <label for="nivel" class="form-label">Nivel del heroe</label>
              <input type="text" class="form-control" id="nivel" placeholder="Nivel" name="nivel">
            </div>
            <div class="mb-3">
              <label for="ataque" class="form-label">Ataque del Heroe</label>
              <input type="text" class="form-control" id="ataque" placeholder="Ataque" name="ataque">
            </div>
            <div class="mb-3">
              <label for="pareja" class="form-label">Pareja del heroe</label>
              <input type="text" class="form-control" id="pareja" placeholder="Nivel" name="pareja">
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
