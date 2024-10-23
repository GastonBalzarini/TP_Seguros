<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.Seguro, dominio.SeguroDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Agregar Seguros</title>
</head>
<body>
    <a href="Inicio.jsp">Inicio</a>
    <a href="SeguroController">Agregar Seguros</a>
    <a href="servletUsuario">Listar Seguros</a>
    
    <h1>Agregar Seguros</h1>

    <% 
        // Mostrar mensaje de error o �xito si existe
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) { 
    %>
        <div><%= mensaje %></div>
    <% 
        } 
    %>

    <form action="SeguroController" method="post">
        <table>
            <tr>
                <td><label for="idSeguro">Id Seguro:</label></td>
                <td>
                <% 
                // Obtener el idSeguro desde el request que envi� el servlet
                Integer idSeguro = (Integer) request.getAttribute("nuevoIdSeguro");
                if (idSeguro != null) {
                    out.print(idSeguro); // Mostrar el ID generado autom�ticamente
                } else {
                    out.print("ID no disponible"); // Mostrar mensaje si el ID no est� disponible
                }
                    %>
                <input type="hidden" id="IdSeguro" name="IdSeguro" value="<%= idSeguro%>"/>
</td> <!-- Muestra el idSeguro -->
          
            </tr>
            <tr>
                <td><label for="descripcion">Descripci�n:</label></td>
                <td><input type="text" id="descripcion" name="descripcion" required></td>
            </tr>
            <tr>
                <td><label for="tipoSeguro">Tipo de Seguro:</label></td>
                <td>
                    <select id="tipoSeguro" name="idTipo" required>
                        <option value="1">Seguro de casas</option>
                        <option value="2">Seguro de vida</option>
                        <option value="3">Seguro de autos</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="costoContratacion">Costo contrataci�n:</label></td>
                <td><input type="text" id="costoContratacion" name="costoContratacion" required></td>
            </tr>
            <tr>
                <td><label for="costoMaximoAsegurado">Costo M�ximo Asegurado:</label></td>
                <td><input type="text" id="costoMaximoAsegurado" name="costoAsegurado" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Aceptar">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
