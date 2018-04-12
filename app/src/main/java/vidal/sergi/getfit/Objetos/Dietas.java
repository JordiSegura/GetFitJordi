package vidal.sergi.getfit.Objetos;

import android.content.Intent;

/**
 * Created by alu2011187 on 15/03/2018.
 */

public class Dietas {

    private String Nombre;
    private String Calorias;

    public Dietas(){}


    public String getNombre() {
        return Nombre;
    }

    public String getCalorias() {

        return Calorias;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public void setCalorias(String calorias) {
        this.Calorias = calorias;
    }
}
