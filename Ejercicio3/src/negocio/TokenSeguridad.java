package negocio;

public class TokenSeguridad extends MetodoAutenticacion {
    private String codigoToken;

    public TokenSeguridad(int nivelSeguridad, String codigoToken) {
        super(nivelSeguridad);
        this.codigoToken = codigoToken;
    }

    public String getCodigoToken() {
        return codigoToken;
    }

    @Override
    public String autenticar() {
        return "Token " + codigoToken + " validado";
    }

    @Override
    public String mostrarInformacion() {
        return "Metodo: Token de seguridad\n"
                + super.mostrarInformacion()
                + "Codigo del token: " + codigoToken + "\n"
                + "----------------------------\n";
    }
}