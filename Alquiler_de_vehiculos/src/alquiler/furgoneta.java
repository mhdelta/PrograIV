/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class furgoneta extends Vehiculo{
    
    Scanner in = new Scanner(System.in);

    public double capacidad = 0;

    furgoneta() {
    }

    public void devolver() {
        System.out.println("Cuantos km recorrio?");
        this.km_acumulados += in.nextDouble();
        this.estado = 'N';
        this.totalPago += this.km_acumulados * this.precioxkm;
        System.out.print("Totala pagar: ");
        System.out.println(this.totalPago);
    }

    public void alquilar() {
        System.out.println("Cuanta capacidad de carga?");
        double capacidad = in.nextDouble();
        this.precioxkm = 0.5;
        this.estado = 'A';
        System.out.println("Cual es la matricula de la furgoneta?");
        this.matricula = in.next();
    }
    
}
