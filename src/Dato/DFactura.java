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
        this("", "", 0, "", "");
    }

    public DFactura(String id, String fecha, double monto, String nit, String nombre) {
        this.id = id;
        this.fecha = Date.valueOf(fecha);
        this.monto = monto;
        this.nit = nit;
        this.nombre = nombre;
        this.table = "factura";
        this.db = new Db();
        this.message = "----------Lista de facturas----------";
    }
  
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public ArrayList<Object []> getLista(){
        ArrayList<Object []> l = new ArrayList<>();
        String sql = "select * from " + table;
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
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return l;
    }
     
    public void agregar(String id, String fecha, double monto, String nit, String nombre){
        String sql="insert into " + table + "(id, fecha, monto, nit, nombre) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, id);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setDouble(3, monto);
            ps.setString(4, nit);
            ps.setString(5, nombre);
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    public void actualizar(String idA, String i, String f, double m, String nit, String n) {
        String sql = "update " + table + " set id=?,fecha=?,monto=?,nit=?,nombre=? where id=?";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, i);
            ps.setDate(2, Date.valueOf(f));
            ps.setDouble(3, m);
            ps.setString(4, nit);
            ps.setString(5, n);            
            ps.setString(6, idA);            
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    public void eliminar(String id) {
        String sql = "delete from " + table + " where id=" + id;
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    public static void main(String[] args) {
        DFactura a = new DFactura("2", "2022-09-15", 4.5, "31231", "alejandro lop");
//        a.agregar("3", "2022-09-15", 25.5, "31231", "alejandro lop");

//        a.actualizar("3", "3", "2022-09-15", 15, "31243", "carlos hugo");
ArrayList<Object []> ls = a.getLista();
      
        for (int i = 0; i < ls.size(); i++) {
            Object[] e = ls.get(i);
            System.out.println(e[1]);
        }
    
//        Object a =  new Object();
////        a = 1313;
//        a = 1564;
//        System.out.println(a);
    }
    
}
