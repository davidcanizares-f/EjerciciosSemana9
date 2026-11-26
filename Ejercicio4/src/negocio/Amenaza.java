package negocio;

import java.util.ArrayList;

public abstract class Amenaza {
    private String nombre;
    private int nivelRiesgo;
    private ArrayList<Alerta> alertas;

    public Amenaza(String nombre, int nivelRiesgo) {
        this.nombre = nombre;
        this.nivelRiesgo = nivelRiesgo;
        alertas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public int cantidadAlertas() {
        return alertas.size();
    }

    public abstract String getTipo();

    public abstract String generarRecomendacion();

    public Alerta generarAlerta() {
        Alerta alerta = new Alerta(generarRecomendacion());
        alertas.add(alerta);
        return alerta;
    }

    public String mostrarInformacion() {
        return "Tipo : " + getTipo() + "\n"
                + "Nombre: " + nombre + "\n"
                + "Nivel de riesgo : " + nivelRiesgo + "\n"
                + "Alertas: " + alertas.size() + "\n";
    }

    public String mostrarAlertas() {
        String resultado = "";
        for (Alerta a : alertas) {
            resultado += "Amenaza : " + nombre + " (" + getTipo() + ")\n"
                    + a.mostrarInformacion()
                    + "----------------------------\n";
        }
        return resultado;
    }
}