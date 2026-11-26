package negocio;

public class HuellaDigital extends MetodoAutenticacion {
    private String dedo;

    public HuellaDigital(int nivelSeguridad, String dedo) {
        super(nivelSeguridad);
        this.dedo = dedo;
    }

    public String getDedo() {
        return dedo;
    }

    @Override
    public String autenticar() {
        return "Huella digital verificada (dedo: " + dedo + ")";
    }

    @Override
    public String mostrarInformacion() {
        return "Metodo : Huella digital\n"
                + super.mostrarInformacion()
                + "Dedo registrado : " + dedo + "\n"
                + "----------------------------\n";
    }
}