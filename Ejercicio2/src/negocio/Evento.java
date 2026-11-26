package negocio;

public class Evento {
    private String descripcion;
    private String nivelRiesgo;

    public Evento(String descripcion, String nivelRiesgo) {
        this.descripcion = descripcion;
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String mostrarInfo() {
        return "Descripcion : " + descripcion + "\n"
                + "Riesgo: " + nivelRiesgo + "\n"
                + "----------------------------\n";
    }
}