/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garaje;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author mhdelta
 */
public class Garaje {

    public ArrayList<coche> ListaCoches;

    public Garaje() {
        this.ListaCoches = new ArrayList();
    }

    ;

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // TODO code application logic here
        Garaje miGaraje = new Garaje();
        int fin = 0;
        int resp;
        while (fin != 1) {
            System.out.println("Main menu");
            System.out.println("[1]. Anadir coche al garaje");
            System.out.println("[2]. Reparar coche");
            System.out.println("[3]. Ver coches en el garaje");
            System.out.println("[4]. Obtener última reparación");
            System.out.println("[5]. Obtener reparaciones que contengan palabra clave");
            System.out.println("[0]. Salir");

            resp = in.nextInt();
            switch (resp) {
                case 1:
                    coche coche = new coche();
                    miGaraje.ListaCoches.add(coche);
                    break;

                case 2:
                    System.out.println("Ingrese la matrícula del coche a reparar...");
                    String matri = in.next();

                    for (coche c : miGaraje.ListaCoches) {
                        if (Objects.equals(matri, c.matricula)) {
                            c.reparar();
                        } else {
                            System.out.println("El vehiculo no existe");
                        }
                    }

                    break;

                case 3:
                    miGaraje.verCoches();
                    break;

                case 4:
                    System.out.println("Ingrese la matrícula del coche...");
                    String matr = in.next();

                    for (coche c : miGaraje.ListaCoches) {
                        if (Objects.equals(matr, c.matricula)) {
                            c.VerUltimaRep();
                        } else {
                            System.out.println("El vehiculo no existe");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Ingrese la matrícula del coche...");
                    String mat = in.next();

                    for (coche c : miGaraje.ListaCoches) {
                        if (Objects.equals(mat, c.matricula)) {
                            c.VerRepPalabraClave();
                        } else {
                            System.out.println("El vehiculo no existe");
                        }
                    }
                    break;

                case 0:
                    System.out.println("...Hasta pronto !!");
                    fin = 1;
                    break;
            }

        }
    }

    public void verCoches() {
        System.out.println(".................................");

        for (coche c : this.ListaCoches) {
            System.out.print("matrícula....");
            System.out.println(c.matricula);
            System.out.print("Dir propiet....");
            System.out.println(c.direccion_propietario);
            System.out.println("Reparaciones.....");
            for (reparacion r : c.reparaciones) {
                System.out.println("....................");
                System.out.print("Rep:  ");
                System.out.println(r.informacion);
                System.out.print("km al rep:  ");
                System.out.println(r.km_al_reparar);
                System.out.println("....................");
            }
            System.out.println(".............................");
        }
        System.out.println(".................................");

    }

}
