/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triki;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juliana
 */
public class Triki {
    int turno, contp, contimp;
    public JLabel [][] cuadros;
    public Color colorx;
    public Color coloro;
    Boolean gano;

    public Triki() {
        turno = contp = contimp = 1;
        cuadros = new JLabel [][]{{C1, C2, C3}, {C4, C5, C6}, {C7, C8, C9}};
        colorx = Color.red;
        coloro = Color.yellow;
        gano = false;
    }
    
    //Determina de quien es el turno y qué dato debe poner en el cuadro
    public void Dato (JLabel cuadro){
        if (!gano){
            if(cuadro.getText().equals(" ")){
                if (turno == 1){
                    cuadro.setText("X");
                    cuadro.setForeground(colorx);
                    turno = 2;
                    if (contimp >= 3){
                        Verificar("X");
                    }
                    contimp++;  
                }
                else{
                    cuadro.setText("O");
                    cuadro.setForeground(coloro);
                    turno = 1;
                    if (contp >= 3){
                        //Verificar("O");
                    }
                    contp++;  
                }
            }
        }
    }
    
    //verifica si ya se ganó el juego
    public void Verificar (String parametro){
        int contador = 0;
        int a, b;
        
        Boolean reinicio = false;
        for (int z=0; z< 2; z++){
            for (int i= 0; i< cuadros.length; i++){
                for (int j= 0; j< cuadros.length; j++){
                    if (z == 0){ // vertical
                        a = i;
                        b = j;
                    }
                    else{ //horizontal
                        a = j;
                        b = i;
                    }
                    if(cuadros[a][b].getText().equals(parametro)){
                        contador++;
                    }
                }
                
                if(!gano && contador==3){
                    JOptionPane.showMessageDialog(null, "TRIKI");
                    if(JOptionPane.showConfirmDialog(null, "Empezar otra partida?") == 0){
                        Nuevo();
                        reinicio = true;
                    }
                    else{
                        gano = false;
                    }
                    break;
                }
                contador = 0;
            }
        }
        if (!reinicio){ // verifica las diagonales
            int pos;
            for (int i= 0; i< 3; i++){
                for (int j= 0; j< cuadros.length; j++){
                    if (i == 0){
                        pos = j;
                    }
                    else{
                        pos = 2 - j;
                    }
                    if(cuadros[j][pos].getText().equals(parametro)){
                        contador++;
                    }
                }
                if(contador==3){
                    JOptionPane.showMessageDialog(null, "TRIKI");
                    if(JOptionPane.showConfirmDialog(null, "Empezar otra partida?") == 0){
                        Nuevo();
                    }
                    else{
                        gano = false;
                    }
                    break;
                }
                contador = 0;
            }
        }
    }
    
    //reinicia el juego
    public void Nuevo (){
        gano = false;
        turno = contp = contimp = 2;
        colorx = Color.red;
        coloro = Color.yellow;
        for (int i= 0; i< cuadros.length; i++){
            for (int j= 0; j< cuadros.length; j++){
                cuadros[i][j].setText(" ");
            }
        } 
    }
    
    public void Salir(){
        JOptionPane.showMessageDialog(null, "Hasta pronto...");
        System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private javax.swing.JLabel C1;
    private javax.swing.JLabel C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel C4;
    private javax.swing.JLabel C5;
    private javax.swing.JLabel C6;
    private javax.swing.JLabel C7;
    private javax.swing.JLabel C8;
    private javax.swing.JLabel C9;
    
}
