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
public class moto extends Vehiculo {

    Scanner in = new Scanner(System.in);

    public boolean con_Casco = false;

    moto() {
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
        System.out.println("Con casco? y/n");
        String resp = in.next();
        if (Objects.equals(resp, 'y')) {
            this.con_Casco = true;
        }
        this.precioxkm = 0.6;
        this.totalPago = 10;
        this.estado = 'A';
        System.out.println("Cual es la matricula de la moto?");
        this.matricula = in.next();
    }
}
