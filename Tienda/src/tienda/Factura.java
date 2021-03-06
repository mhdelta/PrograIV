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
                listaProductos.add(prod.Agregar());
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
        if (fin == 0) {
            System.out.println("No existe una factura con ese codigo");
        }
    }

    public ArrayList<Factura> EliminarFactura(double numero, ArrayList<Factura> lista) {
        int i = 0;
        int pos = -1;
        for (Factura fac : lista) {
            if (fac.getNumero() == numero) {
                pos = i;
            }
            i++;
        }
        if (pos != -1) {
            lista.remove(pos);
        } else {
            System.out.println("No existe una factura con ese codigo");
        }
        return lista;
    }

    public ArrayList<Factura> AgregarNuevoProducto(double num, ArrayList<Factura> lista) {
        Factura factura_modificada = new Factura();
        int i = 0;
        int pos = -1;
        for (Factura fac : lista) {
            if (fac.getNumero() == num) {
                pos = i;
                lista = fac.EliminarFactura(num, lista);
                factura_modificada.numero = fac.numero;
                listaProductos = fac.listaProductos;
                listaProductos.add(prod.Agregar());
                factura_modificada.setListaProductos(listaProductos);
                lista.add(factura_modificada);
            }
            i++;
        }
        if (pos == -1) {
            System.out.println("No existe una factura con ese codigo");
        }

        return lista;
    }

    public ArrayList<Factura> EliminarProducto(String cod, double num, ArrayList<Factura> lista) {
        Factura factura_modificada = new Factura();
        int i = 0;
        int pos = -1;
        for (Factura fac : lista) {
            if (fac.getNumero() == num) {
                pos = i;
                lista = fac.EliminarFactura(num, lista);
                factura_modificada.numero = fac.numero;
                listaProductos = fac.listaProductos;
                listaProductos = prod.Eliminar(cod, listaProductos);
                factura_modificada.setListaProductos(listaProductos);
                lista.add(factura_modificada);
            }
            i++;
        }
        if (pos == -1) {
            System.out.println("No existe una factura con ese codigo");
        }

        return lista;
    }

    public ArrayList<Factura> CambiarPrecioProducto(double precio, String cod, double num, ArrayList<Factura> lista) {
        Factura factura_modificada = new Factura();
        Producto prod_mod = new Producto();
        int i = 0;
        int pos = -1;
        int pos2 = -1;
        for (Factura fac : lista) {
            if (fac.getNumero() == num) {
                pos = i;
                factura_modificada = fac;
                factura_modificada.setNumero(num);
                ArrayList<Producto> listaProdsaModificar = factura_modificada.getListaProductos();
                
                System.out.print("listaprodsamod: ");
                System.out.println(listaProdsaModificar);
                
                for (Producto p : listaProdsaModificar){
                    System.out.println(p.getCodigo());
                    if (Objects.equals(p.getCodigo(), cod)) {
                        pos2 = i;
                    }
                    i++;
                }
                if (pos2 != -1) {
                    prod_mod.setPrecio(precio);
                    listaProdsaModificar.set(pos2, prod_mod);
                    
                } else {
                    System.out.println("No existe un producto con ese codigo");
                }
                
                lista.set(pos, factura_modificada);
                System.out.println("El producto se modifico con exito");
            }
            i++;
        }
        if (pos != -1) {

        } else {
            System.out.println("No existe una factura con ese codigo");
        }
        
        System.out.println(lista);

        return lista;
    }

    public ArrayList<Factura> ModificarFactura(double num, ArrayList<Factura> lista) {
        Factura factura = new Factura();
        Scanner in = new Scanner(System.in);
        // TODO code application logic here
        int finM = 0;
        while (finM == 0) {
            System.out.println("\t\tMENU MODIFICAR FACTURA # " + num);
            System.out.println("[1]. AGREGAR NUEVO PRODUCTO");
            System.out.println("[2]. ELIMINAR PRODUCTO");
            System.out.println("[3]. CAMBIAR PRECIO");
            System.out.println("[4]. SALIR");
            switch (in.next()) {
                case "1":
//                  AGREGAR NUEVO PRODUCTO
                    System.out.println("ingrese la información del nuevo producto: ");
                    lista = factura.AgregarNuevoProducto(num, lista);
                    break;
                case "2":
//                  ELIMINAR PRODUCTO
                    System.out.println("ingrese el codigo del producto que desea eliminar: ");
                    String cod = in.next();
                    factura.EliminarProducto(cod, num, lista);
                    System.out.println("El producto fue eliminado...");
                    break;
                case "3":
//                  CAMBIAR PRECIO DE UN PRODUCTO
                    System.out.println("ingrese el codigo del producto al que desea cambiarle el precio: ");
                    cod = in.next();
                    System.out.println("digite el nuevo precio: ");
                    Double precio = in.nextDouble();
                    factura.CambiarPrecioProducto(precio, cod, num, lista);
                    break;
                case "4":
                    finM = 1;
                    System.out.println("...Saliendo de modificación...");
                    break;
                default:
                    finM = 1;
                    break;
            }
        }
        return lista;
    }
}
