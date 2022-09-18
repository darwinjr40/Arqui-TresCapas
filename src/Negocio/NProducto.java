package Negocio;

import Dato.DProducto;
import java.util.ArrayList;

public class NProducto {
    
    DProducto dp;

    public NProducto() {
        this(null);
    }

    public NProducto(DProducto datoCategoria) {
        this.dp = datoCategoria;
    }
       
    public DProducto getDato() {
        return dp;
    }

    public void setDato(DProducto dp) {
        this.dp = dp;
    }
//    
    public ArrayList<Object []> getlista() { 
        return dp.getLista();
    }  
//    
//    public ArrayList<NProducto> getlista1() { 
//        ArrayList<DProducto> ld =  dp.getLista();
//        ArrayList<NProducto> l = new ArrayList<>();        
//        ld.forEach((DProducto e)->{
//            l.add(new NProducto(e));
//        });
//        return l;
//    }
    
    public void agregar(String i, String n, double p, String ic){
        dp.agregar(i, n, p, ic);
    }
    
    public void actualizar(String ia, String i, String n, double p, String ic){
        dp.actualizar(ia, i, n, p, ic);
    }
    
    public void eliminar(String id) {
        dp.eliminar(id);
    }
    
    
}
