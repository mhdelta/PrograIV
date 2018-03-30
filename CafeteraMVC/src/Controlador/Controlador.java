/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Modelo;
import Vista.Vista;
import java.util.Objects;
import javax.swing.JButton;

/**
 *
 * @author Willian
 */
public class Controlador implements ActionListener {

    Vista view;
    Modelo model;

    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;

        this.view.iniciarbtn.addActionListener(this);
        this.view.cancelarbtn.addActionListener(this);
        this.view.sabor1.addActionListener(this);
        this.view.sabor2.addActionListener(this);
        this.view.sabor3.addActionListener(this);
        this.view.sabor4.addActionListener(this);
        
        this.view.size1.addActionListener(this);
        this.view.size2.addActionListener(this);
        this.view.size3.addActionListener(this);
        this.view.size4.addActionListener(this);

    }

    public void iniciar() {
        view.setTitle("Operacion MULTIPLICACION");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textoBoton = e.getActionCommand();
        String lastTwoLetters = textoBoton.substring(textoBoton.length() - 2);
        switch (e.getActionCommand()) {
            case "Iniciar":
                System.out.println("servir");
                model.Servir();
                view.resultado.setText(model.getResultado());
                break;
            case "Cancelar":
                System.exit(0);
                break;
            default:
                if(Objects.equals(lastTwoLetters,"Oz")){
                    model.setSize(e.getActionCommand());
                }else{
                    model.setSabor(e.getActionCommand());
                }
                break;
        }
    }
}
