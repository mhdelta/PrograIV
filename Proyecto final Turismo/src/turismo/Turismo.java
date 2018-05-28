/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo;

import turismo.controlador.PrincipalController;

import turismo.model.PrincipalModel;

import turismo.view.Principal;
import turismo.view.Amazonas;
import turismo.view.Cartagena;
import turismo.view.Cliente;
import turismo.view.EjeCafetero;
import turismo.view.Guatape;
import turismo.view.Precio;
import turismo.view.SanAndres;

/**
 *
 * @author utp
 */
public class Turismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal view = new Principal();
        PrincipalModel model = new PrincipalModel();
        PrincipalController controller = new PrincipalController(view, model);
        controller.Iniciar();
        view.setVisible(true);
    }

}
