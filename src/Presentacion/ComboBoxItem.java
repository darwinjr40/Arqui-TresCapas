/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Usuario
 */
public class ComboBoxItem {
    public String key;
    public String value;

    public ComboBoxItem(String k, String v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

