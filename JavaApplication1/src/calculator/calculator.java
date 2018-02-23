/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;


import java.util.Scanner;


/**
 *
 * @author mhdelta
 */
public class calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Aplication scanner 
        Scanner scan = new Scanner(System.in);
        
        // Creo el objeto operaicones
        Operaciones operacion = new Operaciones();
        
        System.out.println("Digite el valor de A: ");
        int a = scan.nextInt();
        System.out.println("Digite el valor de B");
        int b = scan.nextInt();
        int c = operacion.suma(a,b);
        
        System.out.println("la suma es: " + c);
    }
    
}
