/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PERSONAL
 */
public class Libro {
    public String titulo;
    public boolean disponible; 
    public int cantidad;    
    public int cantidad_disponible;
    public int categoria;

    
    Libro(String titulo, int cantidad){
        this.cantidad = cantidad;
        this.titulo = titulo;
    }
}
