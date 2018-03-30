/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteramvc;

import Vista.Vista;
import Modelo.Modelo;
import Controlador.Controlador;
/**
 *
 * @author Willian
 */
public class CafeteraMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista view = new Vista();
        Modelo model = new Modelo();
        Controlador controller = new Controlador(view, model);
        controller.iniciar();
        view.setVisible(true);
    }
    
}
