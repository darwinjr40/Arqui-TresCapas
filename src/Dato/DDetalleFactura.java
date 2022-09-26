package Dato;

import BaseDeDatos.Db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DDetalleFactura {
    int id;
    String idFactura;
    String idProducto;
    double precio;
    int cantidad;

    private final Db db;
    private final String table;
    private String message;
    
    public DDetalleFactura(){
        this("", "", 0, 0);
    }
    public DDetalleFactura(String idFactura, String idProducto, double precio, int cantidad) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.table = "detalleFactura";
        this.db = new Db();
        this.message = "----------Lista de facturas----------";        
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public ArrayList<Object []> getListaFactura(String idFactura){
        ArrayList<Object []> l = new ArrayList<>();
//        String sql = "select precio, cantidad from " + table + " where idFactura="+idFactura+" ORDER BY id";
        String sql = "SELECT p.nombre, d.precio, d.cantidad \n" +
                     "FROM factura as f, detallefactura as d, producto as p \n" +
                     "WHERE f.id ="+idFactura+ " and d.idFactura = f.id and d.idProducto = p.id";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new Object[]{
                    rs.getString(1),
//                    rs.getString(2),
//                    rs.getString(3),
                    rs.getDouble(2),
                    rs.getInt(3),
                });
            }
        } catch (SQLException e) {
            System.out.println(e);
            message = "****************Algo Salio Mal!**************";
        }
        return l;
    }
     
    public void setValues(String idFactura, String idProducto, double precio, int cantidad){
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void agregar(String idFactura, String idProducto, double precio, int cantidad){
        this.setValues(idFactura, idProducto, precio, cantidad);
        this.agregar();
    }
    public void agregar(){        
        String sql="insert into " + table + "(idFactura, idProducto, precio, cantidad) values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.db.getCon().prepareStatement(sql);           
            ps.setString(1, this.idFactura);
            ps.setString(2, this.idProducto);
            ps.setDouble(3, this.precio);                        
            ps.setDouble(4, this.cantidad); 
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
    
//    public static void main(String[] args) {
//        DDetalleFactura a = new DDetalleFactura();
////        a.agregar("1", "1", 25.5);
//
////        a.actualizar("3", "3", "2022-09-15", 15, "31243", "carlos hugo");
////a.eliminar("1");
//ArrayList<Object[]> ls = a.getListaFactura("5");
////      
//        for (int i = 0; i < ls.size(); i++) {
//            Object[] e = ls.get(i);
//            System.out.println(e[2]);
//        }
//    
////        Object a =  new Object();
//////        a = 1313;
////        a = 1564;
////        System.out.println(a);
//    }
    
}
