/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.CONTROLADOR;
import modelo.MODELO;
import vista.VISTA;

/**
 *
 * @author utp
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VISTA view = new VISTA();
        MODELO model = new MODELO();
        CONTROLADOR controller = new CONTROLADOR(view, model);
        controller.iniciar();
        view.setVisible(true);
        
    }
    
}
