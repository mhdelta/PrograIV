/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author mhdelta
 */
public class Factura {

    Scanner in = new Scanner(System.in);
    private double numero;
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    Producto prod = new Producto();

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public ArrayList getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void Consultar(String numeroFactura) {

//        Tienda tienda = new Tienda();
//        
//        ArrayList listaFac = tienda.listaFacturas;
//        
//        for (int i = 0; i < listaFac.size(); i++) {
//            System.out.println("-----------------");            
//            System.out.print("CODIGO: ");
//            System.out.println(listaFac);
//        }
    }

    public Factura CrearFactura(double numero) {

        Factura factura_creada = new Factura();
        factura_creada.setNumero(numero);
        int fin = 0;
        while (fin == 0) {
            System.out.println("Ingresar producto ? [y / n]");
            String resp = in.next();
            if (Objects.equals(resp, "y")) {
                listaProductos.add(prod.AgregarProducto());
            } else {
                fin = 1;
            }      
        }
        factura_creada.setListaProductos(listaProductos);
        System.out.println("Factura creada con exito!");
        return factura_creada;
    }

    void ImprimirFactura(ArrayList<Factura> fs) {

        System.out.println("Ingrese el numero de la factura a imprimir");
        double resp = in.nextDouble();
        int fin = 0;
        for (Factura fac : fs) {
            if (fac.getNumero() == resp) {
                System.out.println(".....Impresion de la factura.....");
                System.out.print(".....Factura numero:  ");
                System.out.print(fac.getNumero());
                System.out.println(".....");
                ArrayList<Producto> listaProd = fac.getListaProductos();
                for (Producto prod : listaProd) {
                    System.out.print(".....Producto: ");
                    System.out.print(prod.getNombre());
                    System.out.print("  Precio: $");
                    System.out.print(prod.getPrecio());
                    System.out.println(".....");
                }
                fin = 1;
            }
        }
        if(fin == 0){
            System.out.println("No existe una factura con ese codigo");
        }  
    }
}
