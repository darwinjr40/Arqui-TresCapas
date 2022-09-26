/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import BaseDeDatos.Db;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DFactura {
    private String id;
    private Date fecha;
    private double monto;
    private String nit;
    private String nombre;
    
    private final Db db;
    private final String table;
    private String message;

    public DFactura() {
        this("", "2022-09-15", 0, "", "");
    }

    public DFactura(String id, String fecha, double monto, String nit, String nombre) {
        this.id = id;
        this.fecha = Date.valueOf(fecha);
        this.monto = monto;
        this.nit = nit;
        this.nombre = nombre;
        this.table = "factura";
        this.db = new Db();
        this.message = "Lista de facturas";
    }
  
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public ArrayList<Object []> getLista(){
        ArrayList<Object []> l = new ArrayList<>();
        String sql = "select * from " + table + " ORDER BY id desc";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new Object[]{
                    rs.getString(1),
                    rs.getDate(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
            message = "Lista de facturas";
        } catch (SQLException e) {
            System.out.println(e);
            message = "Error!, al cargar la lista de Factura";
        }
        return l;
    }
    
    
    public void setValues(String id, Date fecha, double monto, String nit, String nombre){
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.nit = nit;
        this.nombre = nombre;
    }
    public void agregar(String id, Date fecha, double monto, String nit, String nombre){
        this.setValues(id, fecha, monto, nit, nombre);
        String sql="insert into " + table + "(id, fecha, monto, nit, nombre) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, this.id);
            ps.setDate(2, this.fecha);
            ps.setDouble(3, this.monto);
            ps.setString(4, this.nit);
            ps.setString(5, this.nombre);
            ps.executeUpdate();
            this.message = "Se Registro, Exitosamente una Factura.";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "!Error, al Registrar Factura";
        }
    }
    
    public void actualizar(String idA, String i, String nit, String n) {
        this.id = i;
        this.nit = nit;
        this.nombre = n;
        String sql = "update " + table + " set id=?,nit=?,nombre=? where id=?";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, this.id);
            ps.setString(2, this.nit);
            ps.setString(3, this.nombre);            
            ps.setString(4, idA);            
            ps.executeUpdate();
            this.message = "Se Actualizo, Exitosamente una Factura";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "!Error, al Actualizar Factura";
        }
    }
    
    public void eliminar(String id) {
        String sql = "delete from " + table + " where id=" + id;
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.executeUpdate();
            this.message = "Se elimino, Exitosamente una Factura";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "!Error, al eliminar Factura";
        }
    }
    
        public ArrayList<Object []> getListaDetalle(String idFactura){
        ArrayList<Object []> l = new ArrayList<>();
        String sql = "SELECT p.nombre, d.precio, d.cantidad \n" +
                     "FROM factura as f, detallefactura as d, producto as p \n" +
                     "WHERE f.id ="+idFactura+ " and d.idFactura = f.id and d.idProducto = p.id";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new Object[]{
                    rs.getString(1),
                    rs.getDouble(2),
                    rs.getInt(3),
                });
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "!Error, al Obtener detalles de Factura";
        }
        return l;
    }  
//    public static void main(String[] args) {
//        DFactura a = new DFactura("2", "2022-09-15", 4.5, "31231", "alejandro lop");
//        a.agregar("4", "2022-09-15", 25.5, "31231", "alejandro lopez berdeja");

//        a.actualizar("3", "3", "2022-09-15", 15, "145", "carlos hugo");
//        ArrayList<Object[]> ls = a.getLista();
//
//        for (int i = 0; i < ls.size(); i++) {
//            Object[] e = ls.get(i);
//            System.out.println(e[0]);
//        }

//        Object a =  new Object();
////        a = 1313;
//        a = 1564;
//        System.out.println(a);
//    }
    
}
