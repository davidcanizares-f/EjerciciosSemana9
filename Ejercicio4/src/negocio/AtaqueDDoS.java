package negocio;

public class AtaqueDDoS extends Amenaza {
    private int solicitudesPorSegundo;

    public AtaqueDDoS(String nombre, int nivelRiesgo, int solicitudesPorSegundo) {
        super(nombre, nivelRiesgo);
        this.solicitudesPorSegundo = solicitudesPorSegundo;
    }

    public int getSolicitudesPorSegundo() {
        return solicitudesPorSegundo;
    }

    @Override
    public String getTipo() {
        return "Ataque DDoS";
    }

    @Override
    public String generarRecomendacion() {
        String recomendacion = "Activar la mitigacion de trafico y filtrar las IP atacantes";
        if (getNivelRiesgo() >= 8) {
            recomendacion += ". Contactar al proveedor de red";
        }
        return recomendacion;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + "Solicitudes/seg : " + solicitudesPorSegundo + "\n"
                + "----------------------------\n";
    }
}