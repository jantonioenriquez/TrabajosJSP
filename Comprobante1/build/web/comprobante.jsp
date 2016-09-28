<%-- 
    Document   : comprobante
    Created on : 27/09/2016, 05:00:09 PM
    Author     : Jose Antonio Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form action="ComprobanteController" method="post">
            <fieldset>
                <legend>Registro de comprobantes</legend>
                <div>
                    <label for="idComprobante">Id Comprobante</label>
                    <input type="text" name="idComprobante"
                           value="${comprobante.idComprobante}"
                           placeholder="Id del Comprobante"
                           readonly="readonly" />
                </div>
                <div>
                    <label for="fecha">Fecha</label>
                    <input type="calendar" name="fecha"
                           value="${comprobante.fecha}"
                           placeholder="Fecha"
                           />
                </div>
                <div>
                    <label for="idPedido">ID Pedido</label>
                    <input type="number" name="idPedido"
                           value="${comprobante.idPedido}"
                           placeholder="ID del Pedido"
                           />
                </div>
                <div>
                    <label for="total">Total</label>
                    <input type="text" name="total"
                           value="${comprobante.total}"
                           placeholder="Total"
                           />
                </div> 
                 <div>
                     <input type="submit" value="Guardar" />
                 </div>           
            </fieldset>
        </form>
    </body>
</html>
