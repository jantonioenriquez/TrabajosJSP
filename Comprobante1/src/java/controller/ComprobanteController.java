/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ComprobanteDAO;
import dao.ComprobanteDAOImp;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comprobante;

/**
 *
 * @author Jose Antonio Enrique
 */
public class ComprobanteController extends HttpServlet {

    private final String LISTA_COMPROBANTES = "/lista_comprobantes.jsp";
    private final String AGREGAR_CAMBIAR = "/comprobante.jsp";
    private ComprobanteDAO dao;

    public ComprobanteController() {
        dao = new ComprobanteDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_COMPROBANTES;
            int idComprobante = Integer.parseInt(
                    request.getParameter("idComprobante"));
            dao.borrarComprobante(idComprobante);
            request.setAttribute("comprobantes", dao.desplegarComprobantes());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idComprobante = Integer.parseInt(
                    request.getParameter("idComprobante"));
            Comprobante comprobante = dao.elegirComprobante(idComprobante);
            request.setAttribute("comprobante", comprobante);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTA_COMPROBANTES;
            request.setAttribute("comprobantes",
                    dao.desplegarComprobantes());
        }

        RequestDispatcher view
                = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Comprobante comprobante = new Comprobante();
        comprobante.setFecha(request.getParameter("fecha"));
        comprobante.setIdPedido(Integer.parseInt(
                request.getParameter("idPedido")));
        comprobante.setTotal(Float.parseFloat(
                request.getParameter("total")));

        String idComprobante = request.getParameter("idComprobante");

        if (idComprobante == null || idComprobante.isEmpty()) {
            dao.agregarComprobante(comprobante);
        } else {
            comprobante.setIdComprobante(
                    Integer.parseInt(idComprobante));
            dao.cambiarComprobante(comprobante);
        }

        RequestDispatcher view
                = request.getRequestDispatcher(LISTA_COMPROBANTES);
        request.setAttribute("comprobantes",
                dao.desplegarComprobantes());
        view.forward(request, response);
    }
}
