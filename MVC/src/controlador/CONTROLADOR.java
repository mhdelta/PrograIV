/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MODELO;
import vista.VISTA;

/**
 *
 * @author utp
 */
public class CONTROLADOR implements ActionListener {

    VISTA view;
    MODELO model;

    public CONTROLADOR(VISTA view, MODELO model) {
        this.view = view;
        this.model = model;

        this.view.botonmultiplicar.addActionListener(this);


    }

    public void iniciar() {
        view.setTitle("Operacion MULTIPLICACION");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setNumero1(Integer.parseInt(view.txtcaja1.getText()));
        model.setNumero2(Integer.parseInt(view.txtcaja2.getText()));
        model.multiplicar();
        
        view.resultado.setText(String.valueOf(model.getResultado()));
    }
}
