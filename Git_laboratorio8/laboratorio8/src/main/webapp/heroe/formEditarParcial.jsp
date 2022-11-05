<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="heroeParcial" type="com.example.laboratorio8.model.beans.Heroe" scope="request"/>
<% String error = (String) request.getAttribute("error");%>
<html>
  <head>
    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Editar trabajos</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">
    </head>
  <body>
    <div class='container'>
      <div class="row justify-content-center">
        <div class="col-md-6 col-sm-12 col-lg-4">
          <h1>Editar trabajo parcialmente</h1>
          <form method="post" action="<%=request.getContextPath()%>/HeroeServlet?action=actualizarParcial">
            <input type="hidden" name="id" value="<%=heroeParcial.getHeroeId()%>">
            <div class="mb-3">
              <label for="nombre" class="form-label">Name</label>
              <input type="text" class="form-control <%=error!=null?"is-invalid":""%>" id="nombre"
                     placeholder="Nombre de Heroe" name="nombre" value="<%=heroeParcial.getNombre()%>">
              <% if (error != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="Edad" class="form-label">Edad</label>
              <input type="text" class="form-control" id="Edad"
                     placeholder="años prro" name="edad" value="<%=heroeParcial.getEdad()%>">
            </div>
            <div class="mb-3">
              <label for="Gender" class="form-label">Genero</label>
              <input type="text" class="form-control" id="Gender"
                     placeholder="genero" name="genero" value="<%=heroeParcial.getGenero()%>">
            </div>
            <div class="mb-3">
              <label for="Class" class="form-label">Class</label>
              <input type="text" class="form-control" id="Class"
                     placeholder="clase" name="clase" value="<%=heroeParcial.getClase()%>">
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="<%=request.getContextPath()%>/HeroeServlet" class="btn btn-danger">Regresar</a>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
