/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador;

import MongoConection.MongoCon;
import java.awt.Component;
import java.awt.Frame;
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
import static java.lang.Math.random;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import static javax.swing.JOptionPane.showMessageDialog;
import org.bson.Document;
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

        this.view.ventanaCliente.calcularPrecio.addActionListener(this);
        
        this.view.ventanaPrecio.aceptarPrecio.addActionListener(this);

    }

    public void Iniciar() {
        view.setTitle("COLOMBIA TRAVEL");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Esta función permite revisar si el atributo hoteles, en el objeto
        // San Andrés, contiene un valor igual al nombre del botón presionado,
        // de ser asi lo guarda como el hotel en el objeto paquete.
        // En un futuro el arraylist de hoteles del objeto san andrés, se va a llenar con 
        // valores de la BD.
        if (view.hoteles.contains(e.getActionCommand())) {
            this.paquete.hotel = e.getActionCommand();
        }
        if (view.ciudades_destino.contains(e.getActionCommand())) {
            this.paquete.ciudadDestino = e.getActionCommand();
            this.paquete.costo_vuelo += SumarCostoVuelo(this.paquete.ciudadDestino);
            this.paquete.aeropuerto_destino = BuscarAeropuerto(this.paquete.ciudadDestino);
        }

        // Para verificar los checkbox de las excursiones propongo:
        // anteceder la palabra excursion en todos los lbels de la app
        // luego si tienen esa palabr en el actioncommand se agregan a una lista de excursiones
        // que esta en cada objeto sanandres y asi...
        switch (e.getActionCommand()) {
            case "San Andrés": {
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
                if (this.paquete.hotel == null) {
                    showMessageDialog(null, "Debe seleccionar primero un hotel !");
                    break;
                }
                this.paquete.costo_hotel += SumarCostoHotel(this.paquete.hotel);
                CerrarVentanas(Frame.getFrames());
                this.view.ventanaCliente.setVisible(true);
                this.view.ventanaCliente.setLocationRelativeTo(null);
                break;
            case "Calcular Precio":
                this.ValidarInfoCliente();
                break;
            case "Aceptar":
                this.CerrarVentanas(Frame.getFrames());
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

    private float SumarCostoHotel(String nombre_hotel) {
        MongoConection.MongoCon db = new MongoCon();
        List<Document> hoteles = db.getAllDocuments("hoteles");
        for (Document hotel : hoteles) {
            if (nombre_hotel.equals(hotel.getString("nombre"))) {
                return Integer.parseInt(hotel.getString("precio"));
            }
        }
        return 0;
    }

    private float SumarCostoVuelo(String nombre_ciudad) {
//        MongoConection.MongoCon db = new MongoCon();
//        List<Document> ciudades = db.getAllDocuments("ciudades");
//        for (Document ciudad : ciudades) {
//            if (nombre_ciudad.equals(ciudad.getString("nombre"))) {
//                return Integer.parseInt(ciudad.getString("precio"));
//            }
//        }
        Random rand = new Random();
        int valor = rand.nextInt(200000) + 600000;
        return valor;
    }

    private void CerrarVentanas(Frame[] frames) {
        for (Frame frame : frames) {
            frame.dispose();
        }
    }

    private String BuscarAeropuerto(String ciudadDestino) {
        MongoConection.MongoCon db = new MongoCon();
        List<Document> ciudades = db.getAllDocuments("ciudades");
        for (Document ciudad : ciudades) {
            if (ciudadDestino.equals(ciudad.getString("nombre"))) {
                return ciudad.getString("aeropuerto");
            }
        }
        return "Nombre del aeropuerto no encontrado";
    }

    private void ValidarInfoCliente() {
        System.out.println("Sistema de validación");
        boolean error = false;
        this.paquete.DNI = this.view.ventanaCliente.dni.getText();
        if (this.paquete.DNI.isEmpty() || this.paquete.DNI == null) {
            error = true;
        }
        this.paquete.nombreCliente = this.view.ventanaCliente.nombres.getText();
        if (this.paquete.nombreCliente.isEmpty() || this.paquete.nombreCliente == null) {
            error = true;
        }
        if (this.view.ventanaCliente.cuotas.getText().isEmpty()) {
            error = true;
        } else {
            if (isInteger(this.view.ventanaCliente.cuotas.getText())) {
                if (Integer.parseInt(this.view.ventanaCliente.cuotas.getText()) <= 0) {
                    error = true;
                } else {
                    this.paquete.cuotas = Integer.parseInt(this.view.ventanaCliente.cuotas.getText());
                }
            } else {
                error = true;
            }
        }
        if (this.view.ventanaCliente.si_extranjero.isSelected()) {
            this.paquete.extranjero = true;
        } else if (this.view.ventanaCliente.no_extranjero.isSelected()) {
            this.paquete.extranjero = false;
        } else {
            error = true;
        }

        if (this.view.ventanaCliente.si_mayorista.isSelected()) {
            this.paquete.extranjero = true;
        } else if (this.view.ventanaCliente.no_mayorista.isSelected()) {
            this.paquete.extranjero = false;
        } else {
            error = true;
        }
        if (error) {
            showMessageDialog(null, "La información debe estar completa y las cuotas deben ser superiores a 0");
        } else {
            this.view.ventanaCliente.dispose();
            this.view.ventanaPrecio.setVisible(true);
            this.view.ventanaPrecio.setLocationRelativeTo(null);
            
            this.view.ventanaPrecio.precio.setText("$ 1,000.000.000");
        }

    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
