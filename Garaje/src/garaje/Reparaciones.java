/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garaje;

import java.util.*;


/**
 *
 * @author mhdelta
 */
public class Reparaciones extends Garaje {
    private String Informacion;
    private ArrayList Articulos;
    
    Reparaciones(){};
    
    public Reparaciones(String Informacion, ArrayList Articulos){
        this.Articulos = Articulos;
        this.Informacion = Informacion;
    }

    public String getInformacion() {
        return Informacion;
    }

    public void setInformacion(String Informacion) {
        this.Informacion = Informacion;
    }

    public ArrayList getArticulos() {
        return Articulos;
    }

    public void setArticulos(ArrayList Articulos) {
        this.Articulos = Articulos;
    }
    
    public boolean ValidarKm(double k1, double k2){
        return true;
    }   
}
