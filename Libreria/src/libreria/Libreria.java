/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author juliana
 */
public class Libreria {
    private String titulo;

    public Libreria (){};
    
    public Libreria(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Libreria AgregarLibro(){
        Scanner in = new Scanner(System.in);
        Libreria lib = new Libreria();
        System.out.println("Ingrese el título del libro: ");
        lib.setTitulo(in.nextLine());
        //listaLibros.add(tit);
        return lib;
    }
    
    public void MostrarLibros(ArrayList<Libreria> lista){
        int i = 1;
        System.out.println("LIBROS...");
        for(Libreria lib: lista){
              System.out.println("libro "+ i + " : ");
              System.out.println(lib.titulo);
            i++;
        }
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int fin = 0;
        Scanner in = new Scanner(System.in);
        Libreria libro = new Libreria();
        ArrayList<Libreria> listaLibros = new ArrayList<Libreria>();
        
        while (fin == 0){
            System.out.println("Seleccione una opcion: ");
            System.out.println("(1) Agregar Libro");
            System.out.println("(2) Mostrar Libros");
            System.out.println("(0) Salir");
            
            switch (in.next()){
                case "1": libro = libro.AgregarLibro();
                          listaLibros.add(libro);
                        break;
                case "2": libro.MostrarLibros(listaLibros);
                        break;
                case "0": fin = 1;
                        break;
                default: fin = 1;
                        break;
                        
            }
        }
    }
    
}
