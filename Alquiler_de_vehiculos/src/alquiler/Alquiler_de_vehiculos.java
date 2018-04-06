/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class Alquiler_de_vehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        moto moto = new moto();
        furgoneta furgoneta = new furgoneta();
        coche coche = new coche();
        ArrayList<furgoneta> listafurgoneta = new ArrayList<furgoneta>();
        ArrayList<furgoneta> listafurgonetaEliminadas = new ArrayList<furgoneta>();
        ArrayList<moto> listaMotos = new ArrayList<moto>();
        ArrayList<moto> listaMotosEliminadas = new ArrayList<moto>();
        ArrayList<coche> listacoche = new ArrayList<coche>();
        ArrayList<coche> listacocheEliminadas = new ArrayList<coche>();
//        moto moto = new moto();
//        ArrayList<moto> listaMotos = new ArrayList<moto>();
//        ArrayList<moto> listaMotosEliminadas = new ArrayList<moto>();
//        moto moto = new moto();
//        ArrayList<moto> listaMotos = new ArrayList<moto>();
//        ArrayList<moto> listaMotosEliminadas = new ArrayList<moto>();

        // TODO code application logic here
        int fin = 0;

        while (fin != 1) {
            System.out.println("Alquiler");
            System.out.println("[1]. Alquilar vehiculo");
            System.out.println("[2]. Devolver vehiculo");
            System.out.println("[3]. Dar de alta");
            System.out.println("[4]. Mostrar eliminados");
            System.out.println("[0]. Salir");
            int resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("[1]. Moto");
                    System.out.println("[2]. Furgoneta");
                    System.out.println("[1]. Coche");
                    int resp2 = in.nextInt();
                    switch (resp2) {
                        case 1:
                            moto.alquilar();
                            listaMotos.add(moto);
                            break;
                        case 2:
                            furgoneta.alquilar();
                            listafurgoneta.add(furgoneta);
                            break;
                        case 3:
                            coche.alquilar();
                            listacoche.add(coche);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Digite la matricula del vehiculo a devolver");
                    String matri = in.next();
                    for (moto m : listaMotos) {
                        System.out.println(m);
                        if (Objects.equals(matri, m.matricula)) {
                            System.out.println("Vehiculo encontrado");
                            m.devolver();
                        } else {
                        }
                    }
                    for (furgoneta m : listafurgoneta) {
                        System.out.println(m);
                        if (Objects.equals(matri, m.matricula)) {
                            System.out.println("Vehiculo encontrado");
                            m.devolver();
                        } else {
                        }
                    }
                    for (coche m : listacoche) {
                        System.out.println(m);
                        if (Objects.equals(matri, m.matricula)) {
                            System.out.println("Vehiculo encontrado");
                            m.devolver();
                        } else {
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite la matricula del vehiculo a eliminar");
                    String matri2 = in.next();
                    for (moto m : listaMotos) {
                        System.out.println(m);
                        if (Objects.equals(matri2, m.matricula)) {
                            System.out.println("Vehiculo eliminado");
                            m.estado = 'N';
                            listaMotosEliminadas.add(m);
                        } else {
                        }
                    }
                    for (furgoneta m : listafurgoneta) {
                        System.out.println(m);
                        if (Objects.equals(matri2, m.matricula)) {
                            System.out.println("Vehiculo eliminado");
                            m.estado = 'N';
                            listafurgonetaEliminadas.add(m);
                        } else {
                        }
                    }
                    for (coche m : listacoche) {
                        System.out.println(m);
                        if (Objects.equals(matri2, m.matricula)) {
                            System.out.println("Vehiculo eliminado");
                            m.estado = 'N';
                            listacocheEliminadas.add(m);
                        } else {
                        }
                    }
                    break;
                case 4:
                    for (moto m : listaMotosEliminadas) {
                        if (Objects.equals('N', m.estado)) {
                            System.out.println("matricula: " + m.matricula);
                            System.out.println("km: " + m.km_acumulados);
                            System.out.print("Ultimo pago " + m.totalPago);
                            System.out.println("");
                        } else {
                            System.out.println("No existe el vehiuclo");
                        }
                    }
                    for (furgoneta m : listafurgonetaEliminadas) {
                        if (Objects.equals('N', m.estado)) {
                            System.out.println("matricula: " + m.matricula);
                            System.out.println("km: " + m.km_acumulados);
                            System.out.print("Ultimo pago " + m.totalPago);
                            System.out.println("");
                        } else {
                            System.out.println("No existe el vehiuclo");
                        }
                    }
                    for (coche m : listacocheEliminadas) {
                        if (Objects.equals('N', m.estado)) {
                            System.out.println("matricula: " + m.matricula);
                            System.out.println("km: " + m.km_acumulados);
                            System.out.print("Ultimo pago " + m.totalPago);
                            System.out.println("");
                        } else {
                            System.out.println("No existe el vehiuclo");
                        }
                    }
                    break;

                //salir
                case 0:
                    fin = 1;
                    break;
            }
        }
    }
}
