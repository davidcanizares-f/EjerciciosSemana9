package negocio;

public class ReconocimientoFacial extends MetodoAutenticacion {
    private double porcentajeCoincidencia;

    public ReconocimientoFacial(int nivelSeguridad, double porcentajeCoincidencia) {
        super(nivelSeguridad);
        this.porcentajeCoincidencia = porcentajeCoincidencia;
    }

    public double getPorcentajeCoincidencia() {
        return porcentajeCoincidencia;
    }

    @Override
    public String autenticar() {
        return "Rostro reconocido con " + porcentajeCoincidencia + "% de coincidencia";
    }

    @Override
    public String mostrarInformacion() {
        return "Metodo: Reconocimiento facial\n"
                + super.mostrarInformacion()
                + "Coincidencia: " + porcentajeCoincidencia + "%\n"
                + "----------------------------\n";
    }
}