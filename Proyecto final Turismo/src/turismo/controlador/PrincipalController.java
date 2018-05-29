/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador;

import java.awt.Component;
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
import javax.swing.JCheckBox;
import static javax.swing.JOptionPane.showMessageDialog;
import turismo.model.Paquete;

/**
 *
 * @author PERSONAL
 */
public class PrincipalController implements ActionListener {

    Principal view = new Principal();
    PrincipalModel model = new PrincipalModel();
    Paquete paquete = new Paquete();

    public PrincipalController(Principal view, PrincipalModel model) {
        this.view = view;
        this.model = model;

        this.view.cartagenaBtn.addActionListener(this);
        this.view.amazonasBtn.addActionListener(this);
        this.view.ejecafeteroBtn.addActionListener(this);
        this.view.guatapeBtn.addActionListener(this);
        this.view.sanandresBtn.addActionListener(this);
        
        this.view.ventanaSanAndres.confirmarPaquete.addActionListener(this);
        this.view.ventanaAmazonas.confirmarPaquete.addActionListener(this);
        this.view.ventanaCartagena.confirmarPaquete.addActionListener(this);
        this.view.ventanaEje.confirmarPaquete.addActionListener(this);
        this.view.ventanaGuatape.confirmarPaquete.addActionListener(this);
        
        
        this.view.ventanaSanAndres.h1.addActionListener(this);
        
        
        this.view.ventanaSanAndres.e1.addActionListener(this);
        this.view.ventanaSanAndres.e2.addActionListener(this);
        this.view.ventanaSanAndres.e3.addActionListener(this);
        this.view.ventanaSanAndres.e4.addActionListener(this);

    }

    public void Iniciar() {
        view.setTitle("COLOMBIA TRAVEL");
        view.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        // Esta función permite revisar si el atributo hoteles, en el objeto
        // San Andrés, contiene un valor igual al nombre del botón presionado,
        // de ser asi lo guarda como el hotel en el objeto paquete.
        // En un futuro el arraylist de hoteles del objeto san andrés, se va a llenar con 
        // valores de la BD.
        if (view.ventanaSanAndres.hoteles.contains(e.getActionCommand())){
            this.paquete.hotel = e.getActionCommand();
        }
        
        // Para verificar los checkbox de las excursiones propongo:
        // anteceder la palabra excursion en todos los lbels de la app
        // luego si tienen esa palabr en el actioncommand se agregan a una lista de excursiones
        // que esta en cada objeto sanandres y asi...
        
        System.out.println(this.paquete.Excursiones);
        
        switch (e.getActionCommand()) {
            case "San Andres": {
                try {
                    boolean res = model.ValidarFechas(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                    res = true;
                    if (res) {
                        this.LlenarInfoPrimeraVentana(e);

                        this.view.ventanaSanAndres.setVisible(true);
                        this.view.ventanaSanAndres.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("San Andrés window open");
                    } else {
                        showMessageDialog(null, "Ingrese una fecha correcta!");
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
                        this.LlenarInfoPrimeraVentana(e);

                        
                        this.view.ventanaCartagena.setVisible(true);
                        this.view.ventanaCartagena.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Cartagena window open");
                    } else {
                        showMessageDialog(null, "Ingrese una fecha correcta!");
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
                        this.LlenarInfoPrimeraVentana(e);

                        this.view.ventanaEje.setVisible(true);
                        this.view.ventanaEje.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Eje Cafetero window open");
                    } else {
                        showMessageDialog(null, "Ingrese una fecha correcta!");
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
                        this.LlenarInfoPrimeraVentana(e);

                        this.view.ventanaGuatape.setVisible(true);
                        this.view.ventanaGuatape.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("Guatapé window open");
                    } else {
                        showMessageDialog(null, "Ingrese una fecha correcta!");
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
                        this.LlenarInfoPrimeraVentana(e);

                        this.view.ventanaAmazonas.setVisible(true);
                        this.view.ventanaAmazonas.setLocationRelativeTo(null);
                        view.dispose();
                        System.out.print("amazonas window open");
                    } else {
                        showMessageDialog(null, "Ingrese una fecha correcta!");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Confirmar paquete":
                break;
            case "Cancelar":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void LlenarInfoPrimeraVentana(ActionEvent e) {
        this.paquete.ciudadDestino = e.getActionCommand();
        this.paquete.fechaIni = view.diaI.getText() + "/" + view.mesI.getText() + "/" + view.añoI.getText();
        this.paquete.fechaFin = view.diaF.getText() + "/" + view.mesF.getText() + "/" + view.añoF.getText();
    }
}
