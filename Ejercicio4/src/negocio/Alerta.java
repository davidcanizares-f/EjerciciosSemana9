package negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alerta {
    private String fechaHora;
    private String recomendacionAutomatica;

    public Alerta(String recomendacionAutomatica) {
        this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.recomendacionAutomatica = recomendacionAutomatica;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getRecomendacionAutomatica() {
        return recomendacionAutomatica;
    }

    public String mostrarInformacion() {
        return "Fecha y hora: " + fechaHora + "\n"
                + "Recomendacion: " + recomendacionAutomatica + "\n";
    }
}