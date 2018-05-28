/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador;

import turismo.model.PrincipalModel;
import turismo.view.Principal;
import turismo.view.Amazonas;
import turismo.view.Cartagena;
import turismo.view.Cliente;
import turismo.view.EjeCafetero;
import turismo.view.Guatape;
import turismo.view.Precio;
import turismo.view.SanAndres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class PrincipalController implements ActionListener {

    Principal view = new Principal();
    PrincipalModel model = new PrincipalModel();

    public PrincipalController(Principal view, PrincipalModel model) {
        this.view = view;
        this.model = model;

        this.view.cartagenaBtn.addActionListener(this);
        this.view.amazonasBtn.addActionListener(this);
        this.view.ejecafeteroBtn.addActionListener(this);
        this.view.guatapeBtn.addActionListener(this);
        this.view.sanandresBtn.addActionListener(this);
    }

    public void Iniciar() {
        view.setTitle("COLOMBIA TRAVEL");
        view.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "San Andres": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    if (res) {
                        SanAndres ventanaSanAndres = new SanAndres();
                        ventanaSanAndres.setVisible(true);
                        ventanaSanAndres.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("San Andrés window open");
                    } else {
                        System.out.println("error in fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Cartagena": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    if (res) {
                        Cartagena ventanaCartagena = new Cartagena();
                        ventanaCartagena.setVisible(true);
                        ventanaCartagena.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Cartagena window open");
                    } else {
                        System.out.println("error in fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Eje Cafetero": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    if (res) {
                        EjeCafetero ventanaEje = new EjeCafetero();
                        ventanaEje.setVisible(true);
                        ventanaEje.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Eje Cafetero window open");
                    } else {
                        System.out.println("error in fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Guatapé": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    if (res) {
                        Guatape ventanaGuatape = new Guatape();
                        ventanaGuatape.setVisible(true);
                        ventanaGuatape.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Guatapé window open");
                    } else {
                        System.out.println("error in fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Amazonas": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    if (res) {
                        Amazonas ventanaAmazonas = new Amazonas();
                        ventanaAmazonas.setVisible(true);
                        ventanaAmazonas.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("amazonas window open");
                    } else {
                        System.out.println("error in fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Cancelar":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
