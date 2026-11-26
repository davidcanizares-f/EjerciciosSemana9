package negocio;

public class Servidor {
    private String nombreServidor;
    private Evento[] eventos;

    public Servidor(String nombreServidor, Evento[] eventos) {
        this.nombreServidor = nombreServidor;
        this.eventos = eventos;
    }

    public String getNombreServidor() {
        return nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    public int contarPorNivel(String nivel) {
        int contador = 0;
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null && eventos[i].getNivelRiesgo().equalsIgnoreCase(nivel)) {
                contador++;
            }
        }
        return contador;
    }

    public String mostrarEventos() {
        String resultado = "";
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null) {
                resultado += eventos[i].mostrarInfo();
            }
        }
        return resultado;
    }
}