package negocio;

public class Phishing extends Amenaza {
    private String remitente;

    public Phishing(String nombre, int nivelRiesgo, String remitente) {
        super(nombre, nivelRiesgo);
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    @Override
    public String getTipo() {
        return "Phishing";
    }

    @Override
    public String generarRecomendacion() {
        String recomendacion = "Bloquear al remitente " + remitente + " y avisar a los usuarios";
        if (getNivelRiesgo() >= 8) {
            recomendacion += ". Forzar el cambio de contrasenas";
        }
        return recomendacion;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + "Remitente: " + remitente + "\n"
                + "----------------------------\n";
    }
}