/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Biblio;
import Vista.Vista;
import java.text.ParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Willian
 */
public class Controlador implements ActionListener {

    Vista view;
    Biblio biblio;

    public Controlador(Vista view, Biblio model) {
        this.view = view;
        this.biblio = model;

        // Aqui van los botones del view
        this.view.ejecutar_pr.addActionListener(this);

        this.view.ejecutar_ag.addActionListener(this);

        this.view.reservar_re.addActionListener(this);

        this.view.retirar_re.addActionListener(this);

        this.view.consultar_co.addActionListener(this);

    }

    public void iniciar() {
        this.view.setTitle("Biblioteca");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String result = null;
        String titulo = null;
        String[] fecha = null;
        String nom_user = null;
        String[] fecha_ini = null;
        String[] fecha_fin = null;

        switch (e.getActionCommand()) {
            case "PRESTAR":
                System.out.println("Prestar");
                titulo = this.view.titulo_libro_pr.getText();
                fecha = this.view.fecha_pr.getText().split("/");
                nom_user = this.view.nombre_usuario_pr.getText();
                result = this.biblio.Gen_prestamo(titulo, fecha, nom_user);
                this.view.resultado_pr.setText(result);

                break;
            case "AGREGAR":
                System.out.println("Agregar libro ");
                result = biblio.Registrar_Libro(this.view.titulo_libro_ag.getText(), Integer.parseInt(this.view.cantidad_ag.getText()), Integer.parseInt(this.view.categoria_ag.getText()));
                this.view.resultado_ag.setText(result);

            case "RESERVAR":
                System.out.println("Reservar");
                titulo = this.view.titulo_libro_re.getText();
                fecha_ini = this.view.fecha_ini_re.getText().split("/");
                fecha_fin = this.view.fecha_fin_re.getText().split("/");
                if (!isNumeric(fecha_ini[0]) || !isNumeric(fecha_fin[0])) {
                    result = "Las fechas no son válidas";
                } else {
                    nom_user = this.view.user_re.getText();
                    try {
                        result = this.biblio.Gen_reserva(titulo, fecha_ini, fecha_fin, nom_user);
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.view.resultado_re.setText(result);
                break;
            case "RETIRAR":
                System.out.println("Retirar");
                titulo = this.view.titulo_libro_re.getText();
                String[] fecha_retiro = this.view.fecha_retiro_re.getText().split("/");
                nom_user = this.view.user_re.getText();
                if (!isNumeric(fecha_retiro[0])) {
                    result = "Las fechas no son válidas";
                } else {
                    try {
                        result = this.biblio.Retirar(titulo, fecha_retiro, nom_user);
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.view.resultado_re.setText(result);
                break;

            case "CONSULTAR":
                result = null;
                System.out.println("Consultar");
                titulo = this.view.titulo_libro_co.getText();
                String[] fecha_consulta = this.view.fecha_consulta_co.getText().split("/");
                nom_user = this.view.nombre_usuario_co.getText();
                 {
                    try {
                        result = this.biblio.Consultar(titulo, fecha_consulta, nom_user);
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.view.resultado_co.setText(result);
                break;

            case "Cancelar":
//                System.exit(0);
                break;
            default:

        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
