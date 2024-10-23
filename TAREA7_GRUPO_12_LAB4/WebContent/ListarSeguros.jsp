<%@page import="dominio.Seguro"%>
<%@page import="dominio.SeguroDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a>
<a href="SeguroController">Agregar Seguros</a>
<a href="servletUsuario">Listar Seguros</a>
<h1>"Tipo de seguros en la base de datos"</h1>
<form action="servletUsuario" method="post">
    <label for="tipoSeguro">Busqueda por Tipo de Seguro:</label>
    <select id="tipoSeguro" name="idTipo">
      <option value="1">Seguro de casas</option>
      <option value="2">Seguro de vida</option>
      <option value="3">Seguro de autos</option>
    </select>
    <input type="submit" value="Filtrar">
</form>
<%
        ArrayList<Seguro> listaSeguros = null;
        if(request.getAttribute("listaS") != null){
            listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
        }
    %>

    <table border="1">
        <tr>
            <th>ID Seguro</th>
            <th>Descripción Seguro</th>
            <th>Tipo de Seguro</th>
            <th>Costo Contratación</th>
            <th>Costo Máximo Asegurado</th>
        </tr>
        <% 
        // Verificar si la lista no es nula y si tiene elementos
        if(listaSeguros != null && !listaSeguros.isEmpty()) {
            for(Seguro seguro : listaSeguros) {
        %>
        <tr>
            <td><%= seguro.getIdSeguro() %></td>
            <td><%= seguro.getDescripcion() %></td>
            <td><%= seguro.getIdTipo() %></td> 
            <td><%= seguro.getCostoContratacion() %></td>
            <td><%= seguro.getCostoAsegurado() %></td>
        </tr>
        <% 
            } 
        } else { 
        %>
        <tr>
            <td colspan="5">No se encontraron seguros.</td>
        </tr>
        <% 
        } 
        %>
    </table>
</body>
</html>