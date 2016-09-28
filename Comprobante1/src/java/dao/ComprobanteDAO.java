/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Comprobante;

/**
 *
 * @author Jose Antonio Enrique
 */
public interface ComprobanteDAO {
     void agregarComprobante(Comprobante comprobante);
    void borrarComprobante(int idComprobante);
    void cambiarComprobante(Comprobante comprobante);
    List<Comprobante> desplegarComprobantes();
    Comprobante elegirComprobante(int idComprobante);
}
