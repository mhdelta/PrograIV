/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.model;

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
    public ArrayList<String> Excursiones;
    
    public float costo_hotel;
    public float costo_vuelo;
    
}
