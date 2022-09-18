package Negocio;

import Dato.DDetalleFactura;
import Dato.DFactura;
import Dato.DProducto;
import java.util.ArrayList;

public class NFactura {
    
    DFactura datoFactura;
    ArrayList<DDetalleFactura> datoDetalleList;
    
    public NFactura() {
        this(null);
    }

    public NFactura(DFactura datoCategoria) {
        this.datoFactura = datoCategoria;
    }

    public DFactura getDatoFactura() {
        return datoFactura;
    }

    public void setDatoFactura(DFactura datoFactura) {
        this.datoFactura = datoFactura;
    }

    public ArrayList<DDetalleFactura> getDatoDetalleList() {
        return datoDetalleList;
    }

    public void setDatoDetalleList(ArrayList<DDetalleFactura> datoDetalleList) {
        this.datoDetalleList = datoDetalleList;
    }
          
    
    public ArrayList<Object []> getlista() { 
        return datoFactura.getLista();
    }  

    
    public void agregar(String id, String fecha, double monto, String nit, String nombre, ArrayList<Object[]> detalleList){
        datoFactura.agregar(id, fecha, monto, nit, nombre);
        for (int i = 0; i < detalleList.size(); i++) {
            Object[] e = detalleList.get(i);
            datoDetalleList.add(new DDetalleFactura((String)e[0], (String)e[1], (double)e[2]));
        }
    }
    
    public void actualizar(String idA, String id, String fecha, double monto, String nit, String nombre){
        datoFactura.actualizar(idA, id, fecha, monto, nit, nombre);
    }
    
    public void eliminar(String id) {
        datoFactura.eliminar(id);
    }
    
    
}
