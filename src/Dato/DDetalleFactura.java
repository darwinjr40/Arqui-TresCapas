package Dato;

import BaseDeDatos.Db;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DDetalleFactura {
    int id;
    String idFactura;
    String idProducto;
    double precio;
    
    private final Db db;
    private final String table;
    private String message;

    public DDetalleFactura(){
        this("", "", 0);
    }
    public DDetalleFactura(String idFactura, String idProducto, double precio) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.precio = precio;
        this.table = "detalleFactura";
        this.db = new Db();
        this.message = "----------Lista de facturas----------";        
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public ArrayList<Object []> getListaFactura(String idFactura){
        ArrayList<Object []> l = new ArrayList<>();
        String sql = "select * from " + table + " where idFactura="+idFactura+" ORDER BY id";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4)
                });
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return l;
    }
     
    public void agregar(String idFactura, String idProducto, double precio){
        String sql="insert into " + table + "(idFactura, idProducto, precio) values(?, ?, ?)";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, idFactura);
            ps.setString(2, idProducto);
            ps.setDouble(3, precio);                        
            ps.executeUpdate();
            this.message = "************EXITO!************";                                
        } catch (SQLException e) {            
            System.err.println(e);
            this.message = "************ERROR!************";
        }
    }
    
//    public void actualizar(String idA, String i, String f, double m, String nit, String n) {
//        String sql = "update " + table + " set id=?,fecha=?,monto=?,nit=?,nombre=? where id=?";
//        try {
//            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
//            ps.setString(1, i);
//            ps.setDate(2, Date.valueOf(f));
//            ps.setDouble(3, m);
//            ps.setString(4, nit);
//            ps.setString(5, n);            
//            ps.setString(6, idA);            
//            ps.executeUpdate();
//            this.message = "************EXITO!************";                                
//        } catch (SQLException e) {            
//            System.err.println(e);
//            this.message = "************ERROR!************";
//        }
//    }
    
    public void eliminar(String idFactura) {
        String sql = "delete from " + table + " where idFactura=" + idFactura;
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
        DDetalleFactura a = new DDetalleFactura();
//        a.agregar("1", "1", 25.5);

//        a.actualizar("3", "3", "2022-09-15", 15, "31243", "carlos hugo");
a.eliminar("1");
//ArrayList<Object[]> ls = a.getListaFactura("1");
////      
//        for (int i = 0; i < ls.size(); i++) {
//            Object[] e = ls.get(i);
//            System.out.println(e[3]);
//        }
    
//        Object a =  new Object();
////        a = 1313;
//        a = 1564;
//        System.out.println(a);
    }
    
}
