/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador;

import MongoConection.MongoCon;
import com.mongodb.BasicDBObject;
import java.awt.Component;
import java.awt.Cursor;
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
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
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

        this.view.ventanaAmazonas.jRadioButton1.addActionListener(this);
        this.view.ventanaAmazonas.jRadioButton4.addActionListener(this);

        this.view.ventanaCartagena.jRadioButton1.addActionListener(this);
        this.view.ventanaCartagena.jRadioButton5.addActionListener(this);
        this.view.ventanaCartagena.jRadioButton6.addActionListener(this);
        this.view.ventanaCartagena.jRadioButton4.addActionListener(this);

        this.view.ventanaEje.jRadioButton1.addActionListener(this);
        this.view.ventanaEje.jRadioButton4.addActionListener(this);
        this.view.ventanaEje.jRadioButton5.addActionListener(this);
        this.view.ventanaEje.jRadioButton6.addActionListener(this);

        this.view.ventanaGuatape.jRadioButton1.addActionListener(this);
        this.view.ventanaGuatape.jRadioButton4.addActionListener(this);
        this.view.ventanaGuatape.jRadioButton5.addActionListener(this);
        this.view.ventanaGuatape.jRadioButton6.addActionListener(this);

        this.view.ventanaSanAndres.jRadioButton4.addActionListener(this);
        this.view.ventanaSanAndres.jRadioButton5.addActionListener(this);
        this.view.ventanaSanAndres.jRadioButton6.addActionListener(this);

        this.view.ventanaCliente.calcularPrecio.addActionListener(this);

        this.view.ventanaPrecio.aceptarPrecio.addActionListener(this);

    }

    public void Iniciar() {
        view.setTitle("COLOMBIA TRAVEL");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (view.hoteles.contains(e.getActionCommand())) {
            this.paquete.hotel = e.getActionCommand();
        }
        if (view.ciudades_destino.contains(e.getActionCommand())) {
            this.paquete.ciudadDestino = e.getActionCommand();
            this.paquete.costo_vuelo += SumarCostoVuelo(this.paquete.ciudadDestino);
            this.paquete.aeropuerto_destino = BuscarAeropuerto(this.paquete.ciudadDestino);
            Random rand = new Random();
            this.paquete.no_vuelo = String.valueOf(rand.nextInt(1000));
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
                this.ValidarExcursiones();
                CerrarVentanas(Frame.getFrames());
                this.view.ventanaCliente.setVisible(true);
                this.view.ventanaCliente.setLocationRelativeTo(null);

                break;
            case "Calcular Precio":
                this.ValidarInfoCliente();
                 {
                    try {
                        double precio = this.paquete.CalcularPrecio(view.diaI.getText(), view.mesI.getText(), view.añoI.getText(), view.diaF.getText(), view.mesF.getText(), view.añoF.getText());
                        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                        String currency = format.format(precio);
                        this.paquete.precio_total = precio;

                        this.view.ventanaPrecio.precio.setText(currency.substring(0, currency.length() - 3));
                    } catch (ParseException ex) {
                        Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "Aceptar":
                this.CerrarVentanas(Frame.getFrames());
                showMessageDialog(null, "Mensaje para IATAFlot: Reserva de vuelo \nDNI: " + this.paquete.DNI + "\nNOMBRE COMPLETO: " + this.paquete.nombreCliente + "\nFECHA DE VUELO: " + this.paquete.fechaIni + "\nNÚMERO DE VUELO: " + this.paquete.no_vuelo + "\nAEROPUERTO DESTINO: " + this.paquete.aeropuerto_destino);
                showMessageDialog(null, "Mensaje para InterHoteling: Reserva de hotel \nDNI: " + this.paquete.DNI + "\nNOMBRE COMPLETO: " + this.paquete.nombreCliente + "\nTIPO DE HABITACIÓN: simple" + "\nFECHA DE LLEGADA: " + this.paquete.fechaIni + "\nFECHA DE SALIDA: : " + this.paquete.fechaFin);
                EnviarMensajesExcursiones();
                boolean disp = VerificarDisponibilidad();
                GuardarPaquete(disp);
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
            if (model.isInteger(this.view.ventanaCliente.cuotas.getText())) {
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
        }
    }

    private void EnviarMensajesExcursiones() {
        if (this.paquete.Excursiones.size() > 0) {
            int cont = 0;
            for (String excur : this.paquete.Excursiones) {
                String excursion = excur.replaceAll("\\s+", "");
                String mensaje = "Destinatario: reservas@" + excursion + ".com.co ";
                mensaje += "\nAsunto: Datos para generar la reserva de una excursión \n";
                Random rand = new Random();
                int hora_int = rand.nextInt(5) + 7;
                Random randi = new Random();
                int min = randi.nextInt(55);
                String hora = String.valueOf(hora_int) + ":" + String.valueOf(min) + " AM";
                String[] fecha_excur = this.paquete.fechaIni.split("/");
                String fecha = String.valueOf(Integer.parseInt(fecha_excur[0]) + cont) + "/" + fecha_excur[1] + "/" + fecha_excur[2];
                cont += 1;
                showMessageDialog(null, mensaje + "DNI: " + this.paquete.DNI + "\nNOMBRE COMPLETO: " + this.paquete.nombreCliente + "\nFECHA: " + fecha + "\nHORA: " + hora + "\n EXCURSIÓN: " + excur);
            }
        }
    }

    public void ValidarExcursiones() {
        //Amazonas
        if (view.ventanaAmazonas.islaMicos.isSelected()) {
            paquete.Excursiones.add("Isla de los Micos");
            paquete.precio_excursiones += 80000;
        }
        if (view.ventanaAmazonas.Comunidades.isSelected()) {
            paquete.Excursiones.add("Comunidades indigenas");
            paquete.precio_excursiones += 30000;
        }
        if (view.ventanaAmazonas.Caminata.isSelected()) {
            paquete.Excursiones.add("Caminata Nocturna");
            paquete.precio_excursiones += 30000;
        }
        if (view.ventanaAmazonas.islaMicos.isSelected()) {
            paquete.Excursiones.add("Canopi");
            paquete.precio_excursiones += 30000;
        }

        // Cartagena
        if (view.ventanaCartagena.CiudadAmurallada.isSelected()) {
            paquete.Excursiones.add("Ciudad Amurallada");
            paquete.precio_excursiones += 80000;
        }
        if (view.ventanaCartagena.PlayaBlanca.isSelected()) {
            paquete.Excursiones.add("Playa Blanca");
            paquete.precio_excursiones += 180000;
        }
        if (view.ventanaCartagena.AtraccionAcuatica.isSelected()) {
            paquete.Excursiones.add("Atracción acuática");
            paquete.precio_excursiones += 35000;
        }

        if (view.ventanaCartagena.RecorridoCiudad.isSelected()) {
            paquete.Excursiones.add("Recorrido a la ciudad");
            paquete.precio_excursiones += 50000;
        }

        //Eje Cafetero
        if (view.ventanaEje.ParqueCafe.isSelected()) {
            paquete.Excursiones.add("Parque del Café");
            paquete.precio_excursiones += 80000;
        }

        if (view.ventanaEje.Termales.isSelected()) {
            paquete.Excursiones.add("Termales");
            paquete.precio_excursiones += 50000;
        }
        if (view.ventanaEje.Salento.isSelected()) {
            paquete.Excursiones.add("Salento");
            paquete.precio_excursiones += 35000;
        }
        if (view.ventanaEje.Arrieros.isSelected()) {
            paquete.Excursiones.add("Parque los arrieros");
            paquete.precio_excursiones += 40000;
        }

        //Guatapé
        if (view.ventanaGuatape.JetSki.isSelected()) {
            paquete.Excursiones.add("Jet Ski");
            paquete.precio_excursiones += 80000;
        }

        if (view.ventanaGuatape.Camping.isSelected()) {
            paquete.Excursiones.add("Camping");
            paquete.precio_excursiones += 50000;
        }
        if (view.ventanaGuatape.Piedra.isSelected()) {
            paquete.Excursiones.add("Piedra del Peñol");
            paquete.precio_excursiones += 20000;
        }
        if (view.ventanaGuatape.Recorrido.isSelected()) {
            paquete.Excursiones.add("Recorrido por la ciudad");
            paquete.precio_excursiones += 15000;
        }

        //San Andrés
        if (view.ventanaSanAndres.Acuario.isSelected()) {
            paquete.Excursiones.add("Acuario");
            paquete.precio_excursiones += 35000;
        }

        if (view.ventanaSanAndres.JetSki.isSelected()) {
            paquete.Excursiones.add("JetSki");
            paquete.precio_excursiones += 80000;
        }
        if (view.ventanaSanAndres.Recorrido.isSelected()) {
            paquete.Excursiones.add("Vuelta a la isla");
            paquete.precio_excursiones += 40000;
        }
        if (view.ventanaSanAndres.Providencia.isSelected()) {
            paquete.Excursiones.add("Providencia");
            paquete.precio_excursiones += 20000;
        }
    }

    private void GuardarPaquete(boolean disponible) {
        MongoConection.MongoCon db = new MongoCon();
        Document paquete = new Document("nombre_cliente", this.paquete.nombreCliente);
        paquete.append("dni_cliente", this.paquete.DNI);
        paquete.append("es_extranjero", this.paquete.extranjero);
        paquete.append("es_mayorista", this.paquete.mayorista);
        paquete.append("fecha_inicial", this.paquete.fechaIni);
        paquete.append("fecha_final", this.paquete.fechaFin);
        paquete.append("ciudad_destino", this.paquete.ciudadDestino);
        paquete.append("hotel", this.paquete.hotel);
        paquete.append("aeropuerto", this.paquete.aeropuerto_destino);
        paquete.append("cuotas", this.paquete.cuotas);
        paquete.append("precio", this.paquete.precio_total);
        paquete.append("excursiones", this.paquete.Excursiones);
        if (disponible) {
            paquete.append("estado", "reservado");
        } else {
            paquete.append("estado", "pendiente");
        }
        db.insertDocument(paquete, "paquetes");
    }

    private boolean VerificarDisponibilidad() {
        Random rand = new Random();
        boolean disp = true;
        float disp_iataFlot = rand.nextFloat();
        float disp_interHotelling = rand.nextFloat();

        for (int i = 0; i < this.paquete.Excursiones.size(); i++) {
            float num = rand.nextFloat();
            if (num > 0.9) {
                showMessageDialog(null, "Respuesta de " + this.paquete.Excursiones.get(i) + "\nLa excursión solicitada no se encuentra disponible");
                disp = false;
            }
        }

        if (disp_iataFlot > 0.9) {
            showMessageDialog(null, "Respuesta de iataFlot\nEl vuelo solicitado no se encuentra disponible");
            disp = false;
        }
        if (disp_interHotelling > 0.9) {
            showMessageDialog(null, "Respuesta de interHotelling\nEl hotel solicitado no se encuentra disponible");
            disp = false;
        }


        if (disp) {
            return true;
        } else {
            showMessageDialog(null, "Estado del paquete\nDebido a que alguna de las reservas no está disponible, el paquete se guardará en estado pendiente");
            return false;
        }
    }
}
