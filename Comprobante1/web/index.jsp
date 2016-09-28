<%-- 
    Document   : index
    Created on : 27/09/2016, 05:55:26 PM
    Author     : Jose Antonio Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprobantes</title>
    </head>
    <body>  
         <jsp:forward 
            page="ComprobanteController?action=listar"></jsp:forward>
    </body>
</html>