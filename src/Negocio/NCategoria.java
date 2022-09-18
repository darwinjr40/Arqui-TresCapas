/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DCategoria;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NCategoria {
    
    DCategoria dc;

    public NCategoria() {
        this(null);
    }

    public NCategoria(DCategoria datoCategoria) {
        this.dc = datoCategoria;
    }
       
    public DCategoria getDatoCategoria() {
        return dc;
    }

    public void setDatoCategoria(DCategoria datoCategoria) {
        this.dc = datoCategoria;
    }
    
    public ArrayList<Object []> getlista() { 
        return dc.getLista();
    }  
    public ArrayList<DCategoria> getlista1() { 
        return dc.getLista1();
    }  
    
    public void agregar(String id, String nombre){   
        dc.agregar(new DCategoria(id, nombre));
    }
    
    public void actualizar(String id, String idNuevo, String nombre){
        dc.actualizar(id, new DCategoria(idNuevo, nombre));
    }
    
    public void eliminar(String id) {
        dc.eliminar(id);
    }
    
    
}
