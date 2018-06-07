/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.model;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class Paquete {
    public String fechaIni, fechaFin;
    public String ciudadDestino, hotel, aeropuerto_destino;
    public String DNI, nombreCliente;
    public boolean extranjero, mayorista;
    public int cuotas;
    public ArrayList<String> Excursiones = new ArrayList<String>(); 
    
    public String no_vuelo;
    
    public float precio_excursiones;
    public float costo_hotel;
    public float costo_vuelo;
    
    public double precio_total;    
    
    
    public double CalcularPrecio (String di, String mi, String ai, String df, String mf, String af) throws ParseException{
        PrincipalModel model = new PrincipalModel();
        float precioPaquete = 0;
        
        float dias = model.CalcularDias(di, mi, ai, df, mf, af);
        
        precioPaquete = (this.costo_hotel * dias) + this.precio_excursiones + this.costo_vuelo; 
        
        if(this.mayorista){
            precioPaquete = precioPaquete + 45000;
        }
        if(this.extranjero){
            if ((precioPaquete*0.2) < 1500000){
                precioPaquete = precioPaquete + 1500000;
            }
            else{
                precioPaquete = (float) (precioPaquete + (precioPaquete * 0.2));
            }          
        }
        if(!this.mayorista && !this.extranjero){
            precioPaquete = (int)(precioPaquete + (precioPaquete * 0.1));
        }
        return precioPaquete; 
    }
}
