<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="heroeParcial" type="com.example.laboratorio8.model.beans.Heroe" scope="request"/>
<% String error = (String) request.getAttribute("error");%>
<% String error2 = (String) request.getAttribute("error2");%>
<% String error3 = (String) request.getAttribute("error3");%>
<% String error4 = (String) request.getAttribute("error4");%>
<% String error5 = (String) request.getAttribute("error5");%>
<% String error6 = (String) request.getAttribute("error6");%>


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
              <input type="text"    class="form-control <%=error!=null?"is-invalid":""%>" id="nombre"
                     placeholder="Nombre de Heroe XD" name="nombre" value="<%=heroeParcial.getNombre()%>">
              <% if (error != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="edad" class="form-label">Edad</label>
              <input type="text" class="form-control <%=error2!=null?"is-invalid":""%>" id="edad"
                     placeholder="años" name="edad" value="<%=heroeParcial.getEdad()%>">
              <% if (error2 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error2%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="genero" class="form-label">Genero</label>
              <input type="text" class="form-control <%=error3!=null?"is-invalid":""%>" id="genero"
                     placeholder="genero" name="genero" value="<%=heroeParcial.getGenero()%>">
              <% if (error3 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error3%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="clase" class="form-label">Clase</label>
              <input type="text" class="form-control  <%=error4!=null?"is-invalid":""%>" id="clase"
                     placeholder="clase" name="clase" value="<%=heroeParcial.getClase()%>">
              <% if (error4 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error4%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="nivel_inicial" class="form-label">Nivel Inicial</label>
              <input type="text" class="form-control  <%=error5!=null?"is-invalid":""%>" id="nivel_inicial"
                     placeholder="Nivel_INICIAL" name="nivel_inicial" value="<%=heroeParcial.getNivel_inicial()%>">
              <% if (error5 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error5%>
              </div>
              <% } %>
            </div>
            <div class="mb-3">
              <label for="ataque" class="form-label">Ataque</label>
              <input type="text" class="form-control  <%=error6!=null?"is-invalid":""%>" id="ataque"
                     placeholder="Ataque" name="ataque" value="<%=heroeParcial.getAtaque()%>">
              <% if (error6 != null) { %>
              <div id="validationServer03Feedback" class="invalid-feedback">
                <%=error6%>
              </div>
              <% } %>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="<%=request.getContextPath()%>/HeroeServlet" class="btn btn-danger">Regresar</a>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
