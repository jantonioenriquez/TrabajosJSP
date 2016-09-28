/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Comprobante;
import util.UtilDB;

/**
 *
 * @author Jose Antonio Enrique
 */
public class ComprobanteDAOImp implements ComprobanteDAO {

    private Connection connection;

    public ComprobanteDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarComprobante(Comprobante comprobante) {
        String sql = "INSERT INTO comprobantes "
                + " (fecha, id_pedido, total) "
                + " VALUES(?, ?, ?)";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setString(1, comprobante.getFecha());
            ps.setInt(2, comprobante.getIdPedido());
            ps.setFloat(3, comprobante.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarComprobante(int idComprobante) {
        String sql = "DELETE FROM comprobantes WHERE id_comprobante=?";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setInt(1, idComprobante);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarComprobante(Comprobante comprobante) {
        String sql = "UPDATE comprobantes SET "
                + " fecha=?, id_pedido=?, total=? "
                + " WHERE id_comprobante=?";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setString(1, comprobante.getFecha());
            ps.setInt(2, comprobante.getIdPedido());
            ps.setFloat(3, comprobante.getTotal());
            ps.setInt(4, comprobante.getIdComprobante());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comprobante> desplegarComprobantes() {
        List<Comprobante> comprobantes = new ArrayList<Comprobante>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM comprobantes");
            while (rs.next()) {
                Comprobante comprobante = new Comprobante(
                        rs.getInt("id_comprobante"),
                        rs.getString("fecha"),
                        rs.getInt("id_pedido"),
                        rs.getFloat("total"));
                comprobantes.add(comprobante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comprobantes;
    }

    @Override
    public Comprobante elegirComprobante(int idComprobante) {
        Comprobante comprobante = null;
        try {
            PreparedStatement ps
                    = connection.prepareStatement(
                            "SELECT * FROM comprobantes"
                            + " WHERE id_comprobante=?");
            ps.setInt(1, idComprobante);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comprobante = new Comprobante(
                        rs.getInt("id_comprobante"),
                        rs.getString("fecha"),
                        rs.getInt("id_pedido"),
                        rs.getFloat("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comprobante;
    }
}
