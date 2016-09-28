<%-- 
    Document   : lista_comprobantes
    Created on : 27/09/2016, 04:57:19 PM
    Author     : Jose Antonio Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Comprobantes</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Fecha</th>
                    <th>Id Pedido</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${comprobantes}" var="comprobante">
                    <tr>
                        <td>${comprobante.idComprobante}</td>
                        <td>${comprobante.fecha}</td>
                        <td>${comprobante.idPedido}</td>
                        <td>${comprobante.total}</td>
                        <td>
                            <a href="ComprobanteController?action=cambiar&idComprobante=${comprobante.idComprobante}">Cambiar</a>
                        </td>
                        <td>
                            <a href="ComprobanteController?action=borrar&idComprobante=${comprobante.idComprobante}">Borrar</a>
                        </td>
                    
                    </tr>
                </c:forEach>
            </tbody>    
        </table>
        
        <p>
            <a href="ComprobanteController?action=agregar">Agregar comprobante</a>
        </p>
    </body>
</html>
