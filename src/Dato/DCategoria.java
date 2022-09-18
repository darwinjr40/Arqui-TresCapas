/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import BaseDeDatos.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class DCategoria {
    private String id;
    private String nombre;
    private final Db db;
    private final String table;
    private String message;
    
    public DCategoria(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        table = "categoria";
        db = new Db();
        this.message = "*******Lista de Categoria*************";
    }

    public String getMessage() {
        return message;
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
    
    public void setValues(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public DCategoria find(String id) {
        String sql = "select * from " + table + " where id=" + id;
        DCategoria dc = null;
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            dc = new DCategoria(rs.getString(1), rs.getString(2));
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
        return dc;
    }
    public ArrayList<Object []> getLista(){
        ArrayList<Object []> lista = new ArrayList<>();
        String sql = "select * from " + table;
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Object[]{rs.getString(1), rs.getString(2)});
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return lista;
    }
    
    public ArrayList<DCategoria> getLista1(){
        ArrayList<DCategoria> lista = new ArrayList<>();
        String sql = "select * from " + table;
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new DCategoria(
                    rs.getString(1),
                    rs.getString(2)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return lista;
    }
    public void agregar(DCategoria categoria){
        String sql="insert into " + table + "(id, nombre) values(?, ?)";
        try {
//            Connection con = db.CreateConnection();
            PreparedStatement ps = db.getCon().prepareStatement(sql);
            ps.setString(1, categoria.getId());
            ps.setString(2, categoria.getNombre());
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    public void actualizar(String id, DCategoria categoria) {
        String sql = "update " + table + " set id=?,nombre=? where id=?";
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getId());
            ps.setString(2, categoria.getNombre());
            ps.setString(3, id);
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
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
    

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
