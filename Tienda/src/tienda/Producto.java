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
public class Producto extends Tienda {

    Scanner in = new Scanner(System.in);
    private String codigo;
    private double precio;
    private String nombre;

    Producto() {
    }

    ;
    
    public Producto(String codigo, double precio, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto Agregar() {
        Producto prod = new Producto();

        System.out.println("Ingrese el codigo del producto");
        prod.setCodigo(in.next());

        System.out.println("Ingrese el nombre del producto");
        prod.setNombre(in.next());

        System.out.println("Ingrese el precio del producto");
        prod.setPrecio(in.nextDouble());

        return prod;
    }

    public ArrayList<Producto> Eliminar(String cod, ArrayList<Producto> listaProd) {
        int i = 0;
        int pos = -1;
        for (Producto prod : listaProd) {
            if (Objects.equals(prod.getCodigo(), cod)) {
                i++;
                pos = i;
            }
        }
        if (pos != -1) {
            listaProd.remove(pos);
        } else {
            System.out.println("No existe un producto con ese codigo");
        }
        return listaProd;
    }

    public Producto CambiarPrecio(Double precio, String cod, ArrayList<Producto> listaProd) {
        int i = 0;
        int pos = -1;
        Producto NuevoProd = new Producto();
        for (Producto prod : listaProd) {
            if (prod.getCodigo() == cod) {
                pos = i;
                NuevoProd = prod;
            }
            System.out.println("no son iguales");
            i++;
        }
        if (pos != -1) {
            NuevoProd.precio = precio;
        } else {
            System.out.println("No existe un producto con ese codigo");
        }
        return NuevoProd;
    }

}
