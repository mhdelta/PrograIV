/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Willian
 */
public class Modelo {
    String size, sabor, resultado;
    ArrayList<String> extras = new ArrayList<String>();

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<String> extras) {
        this.extras = extras;
    }

    public void addExtra(String extra){
        if (this.extras.contains(extra)) {
            return;
        }
        this.extras.add(extra);
        System.out.println(this.extras);
    }
    
    
    
    public void Servir(){
        if (this.size == null){
            this.resultado = "Debe escoger un tamaño";
            return;
        }
        if (this.sabor == null){
            this.resultado = "Debe escoger un sabor";
            return;
        }
        this.resultado = "Sirviendo un " +  this.sabor + " en un vaso " + this.size;
        if (this.extras.size() >= 1) {
            this.resultado += " con ";
        }
        for (String extra : this.extras) {
            this.resultado += extra;
            if (this.extras.size()> 1 && this.extras.indexOf(extra) < this.extras.size() - 2) {
                this.resultado += ", ";
            }
            if (this.extras.indexOf(extra) == this.extras.size() - 2) {
                this.resultado += " y ";
            }
        }
        
    }
}


