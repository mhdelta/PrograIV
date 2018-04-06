/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mhdelta
 */
public class Tienda {

    public ArrayList listaFacturas = new ArrayList();

    Tienda() {
    }

    public Tienda(ArrayList listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public ArrayList getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Factura> listaFacturas = new ArrayList<Factura>();
        // TODO code application logic here
        Factura factura = new Factura();
        int finM = 0;
        int i = 0;
        while (finM == 0) {
            System.out.println("\t\tMENU");
            System.out.println("[1]. CREAR FACTURA");
            System.out.println("[2]. CONSULTAR FACTURA");
            System.out.println("[3]. MODIFICAR FACTURA");
            System.out.println("[4]. ELIMINAR FACTURA");
            System.out.println("[5]. SALIR");
            switch (in.next()) {
                case "1":
//                  CREAR FACTURA
                    Factura facturas = new Factura();
                    facturas = facturas.CrearFactura(i);
                    listaFacturas.add(facturas);
                    i++;
                    break;
                case "2":
//                  IMPRIMIR LA FACTURA CON EL NUMERO
                    factura.ImprimirFactura(listaFacturas);
                    break;
                case "3":
//                  MODIFICAR FACTURA CON EL NUMERO
                    System.out.println("Ingrese el numero de la factura que desea modificar");
                    double num = in.nextDouble();
                    listaFacturas = factura.ModificarFactura(num, listaFacturas);
                    break;
                case "4":
//                  ELIMINAR FACTURA CON EL NUMERO
                    System.out.println("Ingrese el numero de la factura que desea eliminar");
                    double resp = in.nextDouble();
                    Factura facturaE = new Factura();
                    listaFacturas = facturaE.EliminarFactura(resp, listaFacturas);
                    System.out.println("la factura fue eliminada!");
                    break;
                case "5":
                    finM = 1;
                    System.out.println("...Saliendo de facturacion...");
                    break;
                default:
                    finM = 1;
                    break;
            }
        }

    }
}
