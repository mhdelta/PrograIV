/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juliana
 */
public class PrincipalModel {

    public float CalcularDias(String di, String mi, String ai, String df, String mf, String af) throws ParseException {
        if (di.isEmpty() || mi.isEmpty() || ai.isEmpty() || df.isEmpty() || mf.isEmpty() || af.isEmpty()) {
            return -1;
        }
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM");
        String fechai = di + " " + mi;
        String fechaf = df + " " + mf;
        Date date1 = myFormat.parse(fechai);
        Date date2 = myFormat.parse(fechaf);
        long diff = date2.getTime() - date1.getTime();
        float days = (diff / (1000 * 60 * 60 * 24));

        return days;
    }

    public boolean ValidarFechas(String di, String mi, String ai, String df, String mf, String af) throws ParseException {
        if (di.isEmpty() || mi.isEmpty() || ai.isEmpty() || df.isEmpty() || mf.isEmpty() || af.isEmpty()) {
            return false;
        }
        float dias = CalcularDias(di, mi, ai, df, mf, af); 
        if ((Integer.parseInt(ai) >= 2018) && (Integer.parseInt(af) >= 2018)){
            return dias > 1;
        }
        else 
            return false;
    }
    
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
