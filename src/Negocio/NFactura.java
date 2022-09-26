package Negocio;

import Dato.DDetalleFactura;
import Dato.DFactura;
import java.sql.Date;
import java.util.ArrayList;

public class NFactura {
    
    DFactura datoFactura;
    ArrayList<DDetalleFactura> datoDetalleFacturas;
    
    public NFactura() {
        this(new DFactura(), new ArrayList());
    }

    public NFactura(DFactura datoCategoria,  ArrayList<DDetalleFactura> list) {
        this.datoFactura = datoCategoria;
        this.datoDetalleFacturas = list;
    }

    public DFactura getDatoFactura() {
        return datoFactura;
    }

    public void setDatoFactura(DFactura datoFactura) {
        this.datoFactura = datoFactura;
    }

    public ArrayList<DDetalleFactura> getDatoDetalleList() {
        return datoDetalleFacturas;
    }

    public void setDatoDetalleList(ArrayList<DDetalleFactura> datoDetalleList) {
        this.datoDetalleFacturas = datoDetalleList;
    }          
    
    public ArrayList<Object []> getlista() { 
        return datoFactura.getLista();
    }  
    public ArrayList<Object []> getlistaDetalle(String idFactura) { 
        return datoFactura.getListaDetalle(idFactura);
    }  
    
    public void agregar(String id, Date fecha, double monto, String nit, String nombre, ArrayList<Object[]> detalles){
        datoFactura.agregar(id, fecha, monto, nit, nombre);
        datoDetalleFacturas.clear();
        for (Object[] e : detalles){
            DDetalleFactura f = new DDetalleFactura();
            f.agregar(id, (String)e[0], (double)e[1], (int)e[2]);
            datoDetalleFacturas.add(f);             
        }                 
    }
    
    public void actualizar(String idA, String id, String nit, String nombre){
        datoFactura.actualizar(idA, id, nit, nombre);
    }
    
    public void eliminar(String id) {
        datoFactura.eliminar(id);        
    }
    
//    public static void main(String[] args) {
//        NFactura n = new NFactura();
//        ArrayList<Object[]> list = new ArrayList();
//        list.add(new Object[]{"5","1", 5.0, 2});
//        list.add(new Object[]{"5","2", 6.0, 1});
//        list.add(new Object[]{"5","1", 7.0, 1});
////        n.agregar("5", "2022-09-15", "312312", "lopez diego", list);    
////        n.eliminar("5");
//    }
}
