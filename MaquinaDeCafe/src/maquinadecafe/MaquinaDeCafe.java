/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinadecafe;

import java.util.Scanner;
/**
 *
 * @author juliana
 */
public class MaquinaDeCafe implements Cafesencillo, CafeLate, Capuchino, Mocachino {

    public String nomb;
    public double pre;

    public MaquinaDeCafe(){};
    
    public MaquinaDeCafe(String nomb, double pre) {
        this.nomb = nomb;
        this.pre = pre;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        System.out.println("BIENVENIDO");
        
        int fin = 0;
        while(fin == 0){
            Scanner in = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("¿Qué tipo de cafe desea?");
            System.out.println("(1) Sencillo");
            System.out.println("(2) Late");
            System.out.println("(3) Capuchino");
            System.out.println("(4) Mocachino");
            System.out.println("(0) SALIR");

            switch(in.next()){
                case "1": maquina.nomb = Cafesencillo.nombre;
                        maquina.pre = Cafesencillo.precio;
                        break;
                case "2": maquina.nomb = CafeLate.nombre;
                        maquina.pre = CafeLate.precio;
                        break;
                case "3": maquina.nomb = Capuchino.nombre;
                        maquina.pre = Capuchino.precio;
                        break;
                case "4": maquina.nomb = Mocachino.nombre;
                        maquina.pre = Mocachino.precio;
                        break;
                case "0": fin = 1;
                        break;
                default: fin = 1;
                        break;       
            }
            if(fin == 0){
                System.out.println(".................................");
                System.out.println("Sirviendo cafe " + maquina.nomb);
                System.out.println("Precio: " + maquina.pre + " pesos");
            }
            else{
                System.out.println("...Hasta pronto...");
            } 
        }
    }  
}
