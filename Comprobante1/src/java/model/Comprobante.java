/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jose Antonio Enrique
 */
public class Comprobante {
    private int idComprobante;
    private String fecha;
    private int idPedido;
    private float total;

    
    public Comprobante(){
        this(0,"",0,0);
    }
            
    public Comprobante(int idComprobante, String fecha, int idPedido, float total) {
        this.idComprobante = idComprobante;
        this.fecha = fecha;
        this.idPedido = idPedido;
        this.total = total;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Comprobante{" + "idComprobante=" + idComprobante + ", fecha=" + fecha + ", idPedido=" + idPedido + ", total=" + total + '}';
    }
}
