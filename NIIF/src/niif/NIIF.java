/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niif;

//import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author juliana
 */
public class NIIF {
    private long numDNI;
    private String letra;

    public void NIF (){
        this.numDNI = 0;
        this.letra = " ";
    }
    
    public void NIF (long dni){
        this.numDNI = dni;
        this.letra = obtenerLetra(dni);
    }
    
    public long getDNI() {
        return numDNI;
    }

    public void setDNI(long numDNI) {
        this.numDNI = numDNI;
        this.letra = obtenerLetra(numDNI);
    }
    
    public void leer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite el numero de DNI de 8 digitos: ");
        long dni = in.nextLong();
        
        if ((dni >= 10000000) & (dni < 100000000)){
            this.setDNI(dni);
        }
        else{
            System.out.println("El numero ingresado no es valido");
        }
        
        //System.out.println("La letra se ha asignado, desea mostrarla?(y/n)");
        //String resp = in.next();
        //if (Objects.equals(resp, "y")){
        //    mostrar();
        //}
    }
    
    public void mostrar(){
        leer();
        System.out.println("NIF: ");
        System.out.println(this.numDNI + "-" + this.letra);    
    }
    
    private String obtenerLetra(long dni){
        int resto = (int)dni%23;
        String let = " ";
        switch(resto){
            case 0 : let = "T";
                      break;
            case 1 : let = "R";
                      break;
            case 2 : let = "W";
                      break;
            case 3 : let = "A";
                      break;
            case 4 : let = "G";
                      break;
            case 5 : let = "M";
                      break;
            case 6 : let = "Y";
                      break;
            case 7 : let = "F";
                      break;
            case 8 : let = "P";
                    break;
            case 9 : let = "D";
                    break;
            case 10 : let = "X";
                    break;
            case 11 : let = "B";
                    break;
            case 12 : let = "N";
                    break;
            case 13 : let = "J";
                    break;
            case 14 : let = "Z";
                    break;
            case 15 : let = "S";
                     break;
            case 16 : let = "Q";
                    break;
            case 17 : let = "V";
                    break;
            case 18 : let = "H";
                    break;
            case 19 : let = "L";
                    break;
            case 20 : let = "C";
                    break;
            case 21 : let = "K";
                    break;
            case 22 : let = "E";
                    break;       
            default : let = "Z";
        }
        return let;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fin = 0;
        
        NIIF nif = new NIIF();
        
        System.out.println("MENU DE NIIF: ");
        System.out.println("(1) LEER NIIF");
        System.out.println("(2) MOSTRAR NIIF");
        System.out.println("(3) SALIR");
        
        while (fin == 0){
            System.out.println("Digite una opción: ");
            switch(in.next()){
                case "1":  nif.leer();
                            System.out.println("La letra se ha asignado ");
                            break;
                case "2": nif.mostrar();
                            break;
                case "3": fin = 1;
                            System.out.println("has salido del programa...");
                            break;
                default: fin = 1;
                         break;
            }
        }

    }
    
}
