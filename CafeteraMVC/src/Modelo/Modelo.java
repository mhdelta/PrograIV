/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Modelo {
    String size, sabor, resultado;

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
    
    
    
    public void Servir(){
        if (this.size == null){
            this.resultado = "Debe escoger un tamaño";
            return;
        }
        if (this.sabor == null){
            this.resultado = "Debe escoger un sabor";
            return;
        }
        //this.resultado = "Sirviendo un delicioso " +  this.sabor + " en un vaso " + this.size.substring();
    }
}


