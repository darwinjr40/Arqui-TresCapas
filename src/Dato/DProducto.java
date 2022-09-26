/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import BaseDeDatos.Db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class DProducto {
    private String id;
    private String nombre;
    private double precio;
    private String idCategoria;
    private final Db db;
    private final String table;
    private String message;

    public DProducto() {
        this("", "", 0, "");
    }

    public DProducto(String id, String nombre, double precio, String idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.table = "producto";
        this.db = new Db();
        this.message = "----------Lista de Productos----------";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public Object [] getById(String id){
        String sql = "select * from " + table +" where id=" + id;
        Object[] r = null;
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = (new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4)
                });
            }                        
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return r;
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
                    rs.getString(2),    
                    rs.getDouble(3),
                    rs.getString(4) 
                });
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return l;
    }
    
    public ArrayList<DProducto> getLista1(){
        ArrayList<DProducto> lista = new ArrayList<>();
        String sql = "select * from " + table;
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(2));
                lista.add(new DProducto(
                    rs.getString(1),
                    rs.getString(2),    
                    rs.getDouble(3),
                    rs.getString(4)    
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return lista;
    }
    
  
    public void agregar(String i, String n, double p, String ic){
        String sql="insert into " + table + "(id, nombre, precio, idCategoria) values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, i);
            ps.setString(2, n);
            ps.setDouble(3, p);
            ps.setString(4, ic);
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    public void actualizar(String idA, String i, String n, double p, String ic) {
        String sql = "update " + table + " set id=?,nombre=?,precio=?,idCategoria=? where id=?";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, i);
            ps.setString(2, n);
            ps.setDouble(3, p);
            ps.setString(4, ic);
            ps.setString(5, idA);            
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
    
//    public static void main(String[] args) {
//        DProducto a = new DProducto("2", "galleta serrana", 4, "3");
//        System.out.println(a.getById("1")[1]);
////        a.agregar("6", "galleta serrana", 5, "4");
//
////        a.actualizar("2", "3", "galleta serrana", 5, "4");
////a.eliminar("6");
////        Object a =  new Object();
//////        a = 1313;
////        a = 1564;
////        System.out.println(a);
//    }
    
}
