package vidal.sergi.getfit.Objetos;

import java.util.List;

/**
 * Created by alu2011187 on 20/03/2018.
 */

public class Grupo {
    private List<String> nombres;

    public Grupo() {
    }

    public Grupo(List<String> nombres) {
        this.nombres = nombres;
    }

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }
}
