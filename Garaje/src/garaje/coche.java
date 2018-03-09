package garaje;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
class coche {

    Scanner in = new Scanner(System.in);

    public String matricula;
    public String direccion_propietario;
    ArrayList<reparacion> reparaciones;

    public coche() {
        System.out.println("...Matricula...");
        this.matricula = in.next();
        System.out.println("...Dirección del propietario...");
        this.direccion_propietario = in.next();
        this.reparaciones = new ArrayList();
    }

    public void reparar() {
        reparacion rep = new reparacion();
        System.out.println("Info de la reparación...");
        rep.informacion = in.next();
        in.nextLine();
        System.out.println("km al reparar...");
        rep.km_al_reparar = in.nextInt();

        if (this.reparaciones.size() == 0) {

        } else {
            reparacion lastRep = this.reparaciones.get(this.reparaciones.size() - 1);
            if (rep.km_al_reparar < lastRep.km_al_reparar) {
                System.out.println("Los km deben exceder el kilometraje de la última reparación !!...");
                return;
            }
        }

        this.reparaciones.add(rep);
    }

    public void VerUltimaRep() {
        if (this.reparaciones.size() == 0) {
            System.out.println("Este coche no ha sido reparado...");
            return;
        } else {
            reparacion lastRep = this.reparaciones.get(this.reparaciones.size() - 1);
            System.out.print("Rep: ");
            System.out.println(lastRep.informacion);
            System.out.print("km al reparar: ");
            System.out.println(lastRep.km_al_reparar);

        }
    }

    public void VerRepPalabraClave() {
        System.out.println("Digite la palabra clave");
        String pclave = in.next();
        boolean found = false;
        for (reparacion rep : this.reparaciones) {
            if (rep.informacion.contains(pclave)) {
                found = true;
                System.out.print("Rep: ");
                System.out.println(rep.informacion);
                System.out.print("km al reparar: ");
                System.out.println(rep.km_al_reparar);
            }
        }
        if(!found){
            System.out.println("No se encontraron resultados para la palabra clave.");
        }
        

    }
}
