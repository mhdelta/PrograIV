/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PERSONAL
 */
public class Biblio {

    public ArrayList<Libro> libros = new ArrayList<Libro>();
    public ArrayList<User> usuarios = new ArrayList<User>();
    public ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    public ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

    public String result = null;
    public int exitoso;

    public String Registrar_Libro(String titulo, int cantidad, int categoria) {
        Libro libro = new Libro(titulo, cantidad);

        this.exitoso = 1;
        if (cantidad <= 0) {
            this.exitoso = 0;
            this.result = "La cantidad es necesaria";
        }
        for (Libro lib : this.libros) {
            if (lib.titulo.equals(libro.titulo)) {
                this.result = "El libro" + titulo + "ya existe en biblioteca";
                this.exitoso = 0;
            }
        }
        if (categoria > 3 || categoria < 0) {
            this.exitoso = 0;
            this.result = "La categoría debe estar entre 0 y 2";
        }
        if (this.exitoso == 1) {
            libro.disponible = true;
            libro.cantidad_disponible = cantidad;
            libro.categoria = categoria;
            this.libros.add(libro);
            this.result = "El libro " + titulo + " se añadió con éxito";
        }
        return this.result;
    }

    public String Gen_prestamo(String titulo, String[] fecha, String user) {
        this.exitoso = 0;
        Prestamo pres = new Prestamo();
        for (Libro lib : this.libros) {
            if (lib.titulo.equals(titulo)) {
                System.out.println("El libro existe");
                if (lib.cantidad_disponible > 0) {
                    System.out.println("Existen unidades disponibles");
                    this.exitoso = 1;
                    String fecha_entrega = null;
                    switch (lib.categoria) {
                        case 0:
                            fecha_entrega = "5 días";
                            break;
                        case 1:
                            fecha_entrega = "10 días";
                            break;
                        case 2:
                            fecha_entrega = "20 días";
                            break;
                    }
                    this.result = "El prestamo ha sido realizado con éxito\nDía " + fecha[0] + " del mes " + fecha[1] + ".\nSeñor/a " + user + "\nFavor entregar en: " + fecha_entrega;
                    pres.fecha_ini = fecha;
                    pres.titulo_libro = lib.titulo;
                    pres.usuario = user;
                    this.prestamos.add(pres);
                    lib.cantidad_disponible -= 1;
                    //Falta validación de la deuda

                } else {
                    System.out.println("Pero no existen unidades disponibles");
                    this.exitoso = 0;
                    this.result = "No existen unidades disponibles\nUnidades totales: " + lib.cantidad;
                    return this.result;
                }
            }
        }
        if (this.exitoso == 0) {
            this.result = "El libro no fue encontrado en nuestra base de datos";
        }
        return this.result;
    }

    public String Gen_reserva(String titulo, String[] fecha_ini, String[] fecha_fin, String user) throws ParseException {
        this.exitoso = 0;

        Reserva res = new Reserva();
        for (Libro lib : this.libros) {
            if (lib.titulo.equals(titulo)) {
                System.out.println("El libro existe");
                if (lib.cantidad_disponible > 0) {
                    System.out.println("Existen unidades disponibles");
                    this.exitoso = 1;
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM");
                    String dat1 = fecha_ini[0] + " " + fecha_ini[1];
                    String dat2 = fecha_fin[0] + " " + fecha_fin[1];
                    Date date1 = myFormat.parse(dat1);
                    Date date2 = myFormat.parse(dat2);
                    long diff = date2.getTime() - date1.getTime();
                    float days = (diff / (1000 * 60 * 60 * 24));
                    switch (lib.categoria) {
                        case 0:
                            if (days > 5) {
                                this.exitoso = 0;
                                this.result = "Los libros críticos no pueden prestarse\npor mas de 5 días";
                                return this.result;
                            }
                            break;
                        case 1:
                            if (days > 10) {
                                this.exitoso = 0;
                                this.result = "Los libros normales no pueden prestarse\npor mas de 10 días";
                                return this.result;
                            }
                            break;
                        case 2:
                            if (days > 20) {
                                this.exitoso = 0;
                                this.result = "Los libros másivos no pueden prestarse\npor mas de 20 días";
                                return this.result;
                            }
                            break;
                    }
                    res.fecha_ini = fecha_ini;
                    res.fecha_fin = fecha_fin;
                    res.titulo_libro = lib.titulo;
                    res.usuario = user;
                    this.reservas.add(res);
                    lib.cantidad_disponible -= 1;
                    this.result = "La reserva ha sido realizado con éxito\nDía " + fecha_ini[0] + " del mes " + fecha_ini[1] + ".\nSeñor/a " + user + "\nFavor entregar el libro el día: " + fecha_fin[0] + " del mes " + fecha_fin[1];

                } else {
                    System.out.println("Pero no existen unidades disponibles");
                    this.exitoso = 0;
                    this.result = "No existen unidades disponibles\nUnidades totales: " + lib.cantidad;
                    return this.result;
                }
            }
        }
        if (this.exitoso == 0) {
            this.result = "El libro no fue encontrado en nuestra base de datos";
        }

        return this.result;
    }

    public String Retirar(String titulo, String[] fecha_retiro, String user) throws ParseException {
        this.exitoso = 0;
        boolean encontrada = false;
        String[] fecha_reserva = null;

        for (Reserva r : this.reservas) {
            if (r.usuario.equals(user)) {
                System.out.println("Usuario encontrado");
                if (r.titulo_libro.equals(titulo)) {
                    encontrada = true;
                    fecha_reserva = r.fecha_ini;
                }
            }
        }
        if (!encontrada) {
            this.exitoso = 0;
            this.result = "No se encontró la reserva";
            return this.result;
        } else {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM");
            String dat1 = fecha_reserva[0] + " " + fecha_reserva[1];
            String dat2 = fecha_retiro[0] + " " + fecha_retiro[1];
            Date date1 = myFormat.parse(dat1);
            Date date2 = myFormat.parse(dat2);
            long diff = date2.getTime() - date1.getTime();
            float days = (diff / (1000 * 60 * 60 * 24));
            if (days > 2) {
                this.exitoso = 0;
                this.result = "El tiempo para retirar su libro ya expiró\nIntente reservar de nuevo.\nDías después de la reserva: " + String.valueOf(days);
                return this.result;
            } else {
                this.exitoso = 1;
                this.result = "El retiro se ha compeltado con éxito";
                return this.result;
            }
        }
    }

    public String Consultar(String titulo, String[] fecha_consulta, String user) throws ParseException {
        this.exitoso = 0;
        boolean reserva_encontrada = false;
        boolean prestamo_econtrado = false;
        String[] fecha_reserva = null;
        Reserva res = new Reserva();

        for (Reserva r : this.reservas) {
            if (r.usuario.equals(user)) {
                System.out.println("Usuario encontrado");
                if (r.titulo_libro.equals(titulo)) {
                    reserva_encontrada = true;
                    res = r;
                }
            }
        }
        if (!reserva_encontrada) {
        } else {
            this.result = ("Datos de la reserva:\nTítulo del libro:" + res.titulo_libro + "\nFecha de reserva" + res.fecha_ini[0] + "-" + res.fecha_ini[1] + "\nFecha de entrega:" + res.fecha_fin[0] + "-" + res.fecha_fin[1]);
            return this.result;
        }
        Prestamo pres = new Prestamo();

        for (Prestamo r : this.prestamos) {
            if (r.usuario.equals(user)) {
                System.out.println("Usuario encontrado");
                if (r.titulo_libro.equals(titulo)) {
                    prestamo_econtrado = true;
                    pres = r;
                }
            }
        }
        if (!prestamo_econtrado) {
        } else {
            this.exitoso = 0;
            this.result = ("Datos del prestamo :\nTítulo del libro:" + pres.titulo_libro + "\nFecha de reserva" + pres.fecha_ini);
            return this.result;
        }
        return "No se encontraron datos suficientes para completar la operación";
    }
}
