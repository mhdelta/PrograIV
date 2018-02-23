/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author mhdelta
 */
public class Vehiculo {

    Scanner in = new Scanner(System.in);
    ArrayList listVehiculo = new ArrayList();

    public ArrayList llenar() {
        int size = 3;

        for (int i = 0; i <= size; i++) {
            Datos vehiculo = new Datos();

            System.out.println("Ingrese los datos del vehiculo #" + i);

            //Ingreso los datos
            System.out.println("Digite el numero del motor");
            vehiculo.setMotor(in.next());

            System.out.println("Digite el chasis del vehiculo");
            vehiculo.setChasis(in.nextLong());

            System.out.println("Digite el numero del vehiculo");
            vehiculo.setNumero(in.nextLong());

            listVehiculo.add(vehiculo);
        }

        return listVehiculo;

    }

    public void imprimir(ArrayList vehi) {
        for (int i = 0; i < vehi.size(); i++) {
            System.out.println("_____________vehiculo # " + i);
            Datos veh = (Datos) vehi.get(i);
            System.out.println("El numero de motor es -> " + veh.getMotor());
            System.out.println("El numero de chasis es -> " + veh.getChasis());
            System.out.println("El numero de vehiculo es -> " + veh.getNumero());

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList lista = new ArrayList();
        
        Vehiculo vehi = new Vehiculo();
        
        lista = vehi.llenar();
        vehi.imprimir(lista);
    }

}
