package negocio;

import java.util.ArrayList;

public class AnalistaSeguridad {
    private String nombre;
    private ArrayList<Amenaza> amenazasDetectadas;

    public AnalistaSeguridad(String nombre) {
        this.nombre = nombre;
        amenazasDetectadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int cantidadAmenazas() {
        return amenazasDetectadas.size();
    }

    public void registrarAmenaza(Amenaza amenaza) {
        amenazasDetectadas.add(amenaza);
    }

    public Alerta generarAlerta(Amenaza amenaza) {
        if (amenaza != null && amenazasDetectadas.contains(amenaza)) {
            return amenaza.generarAlerta();
        }
        return null;
    }

    public int generarAlertasAutomaticas() {
        int generadas = 0;
        for (Amenaza a : amenazasDetectadas) {
            generarAlerta(a);
            generadas++;
        }
        return generadas;
    }

    public boolean existeAmenazaDeTipo(String tipo) {
        for (Amenaza a : amenazasDetectadas) {
            if (a.getTipo().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }

    public String mostrarAmenazas() {
        String resultado = "";
        for (Amenaza a : amenazasDetectadas) {
            resultado += a.mostrarInformacion();
        }
        return resultado;
    }

    public String mostrarAlertas() {
        String resultado = "";
        for (Amenaza a : amenazasDetectadas) {
            resultado += a.mostrarAlertas();
        }
        return resultado;
    }
}