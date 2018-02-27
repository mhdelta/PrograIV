/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafetera;

/**
 *
 * @author juliana
 */
public class Cafetera {

    private int capacidadMaxima;
    private int cantidadActual;
    
    //cafetera vacia
    public void Cafetera(){
        this.capacidadMaxima = 1000;
        this.cantidadActual= 0;               
    }
    //cafetera llena
    public void Cafetera(int capacidadMax){
        this.cantidadActual = capacidadMax;
    }
    
    // cafetera desfasada 
    public void Cafetera (int capacidadMax, int capacidadAct){
        if (capacidadAct > capacidadMax){
            this.cantidadActual = capacidadMax;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCapacidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    public void LlenarCafetera(){
        this.cantidadActual = this.capacidadMaxima;
        System.out.println("la cafetera se llenó");
    }
    
    public void ServirTaza(int cantidad){
        if(cantidad > this.cantidadActual){
            System.out.println("se sirvió : " + this.cantidadActual + " de cafe");
            this.cantidadActual = 0;
        }else{
            this.cantidadActual = this.cantidadActual - cantidad;
            System.out.println("se sirvió : " + cantidad + " de cafe");
        }   
    }
    
    public void VaciarCafetera(){
        this.cantidadActual = 0;
        System.out.println("se vació la cafetera ");
    }
    
    public void AgregarCafe(int cantidad){
        if (this.cantidadActual + cantidad > this.capacidadMaxima){
            this.cantidadActual = this.capacidadMaxima;
            System.out.println("se agregó " + cantidad + " a la cafetera ");
        }else{
            this.cantidadActual += cantidad;
            System.out.println("se llenó la cafetera");
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Fin = 0;
        
        Cafetera cafetera = new Cafetera(1000);
        
        cafetera.AgregarCafe(700);
        System.out.println(cafetera.cantidadActual);
        
    }
    
}
