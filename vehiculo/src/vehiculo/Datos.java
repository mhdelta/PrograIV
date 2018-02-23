/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculo;

import java.util.ArrayList;

/**
 *
 * @author mhdelta
 */
public class Datos {
    
    private String motor;
    private long chasis;
    private long numero;
    
    Datos(){}
    
    public Datos(String motor, long chasis, long numero){
    this.motor = motor;
    this.chasis = chasis;
    this.numero = numero;
    }
    
    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public long getChasis() {
        return chasis;
    }

    public void setChasis(long chasis) {
        this.chasis = chasis;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    
}


