/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculator;

/**
 *
 * @author mhdelta
 */
public class Operaciones {
    
    int a,b;
    
    Operaciones(){};

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public int suma (int a, int b){
        return a + b;
    }
    
    public int resta (int a, int b){
        return a - b;
    }
}
