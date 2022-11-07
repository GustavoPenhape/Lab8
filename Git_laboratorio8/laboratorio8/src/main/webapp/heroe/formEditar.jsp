<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="heroe_send_jsp" type="com.example.laboratorio8.model.beans.Heroe" scope="request"/>
<html>
  <head>
    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Editar Heroes</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">
    </head>
  <body>
    <div class='container'>
      <div class="row justify-content-center">
        <div class="col-md-6 col-sm-12 col-lg-4">
          <h1>Editar Heroe</h1>
          <form method="post" action="<%=request.getContextPath()%>/HeroeServlet?action=actualizar">
            <input type="hidden" name="IdHeroes" value="<%=heroe_send_jsp.getHeroeId()%>">
            <div class="mb-3">
              <label for="nombre" class="form-label">Nombre del Heroe</label>
              <input type="text" class="form-control" id="nombre" placeholder="Nombre del Heroe"
                     name="nombre" value="<%=heroe_send_jsp.getNombre()%>">
            </div>
            <div class="mb-3">
              <label for="edad" class="form-label">Edad del Heroe</label>
              <input type="text" class="form-control" id="edad" placeholder="Edad del Heroe"
                     name="edad" value="<%=heroe_send_jsp.getEdad()%>">
            </div>
            <div class="mb-3">
              <label for="genero" class="form-label">Genero</label>
              <input type="text" class="form-control" id="genero" placeholder="Genero"
                     name="genero" value="<%=heroe_send_jsp.getGenero()%>">
            </div>
            <div class="mb-3">
              <label for="nivel" class="form-label">Nivel del Heroe</label>
              <input type="text" class="form-control" id="nivel" placeholder="Nivel"
                     name="nivel" value="<%=heroe_send_jsp.getNivel_inicial()%>">
            </div>
            <div class="mb-3">
              <label for="clase" class="form-label">Clase</label>
              <input type="text" class="form-control" id="clase" placeholder="Clase de Heroe"
                     name="clase" value="<%=heroe_send_jsp.getClase()%>">
            </div>
            <div class="mb-3">
              <label for="ataque" class="form-label">Ataque</label>
              <input type="text" class="form-control" id="ataque" placeholder="Ataque"
                     name="ataque" value="<%=heroe_send_jsp.getAtaque()%>">
            </div>
            <div class="mb-3">
              <label for="pareja" class="form-label">Pareja</label>
              <input type="text" class="form-control" id="pareja" placeholder="Pareja"
                     name="pareja" value="<%=heroe_send_jsp.getPareja_id()%>">
            </div>
            <div class="mb-3">
              <label for="puntos_exp" class="form-label">Points</label>
              <input type="text" class="form-control" id="puntos_exp" placeholder="puntitos" name="puntos_exp"
                    value="<%=heroe_send_jsp.getPareja_id()%>">
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="<%=request.getContextPath()%>/HeroeServlet" class="btn btn-danger">Regresar</a>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
