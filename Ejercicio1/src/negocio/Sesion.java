package negocio;

public class Sesion {
    private String ipConexion;
    private String horaInicio;
    private Usuario usuario;

    public Sesion(String ipConexion, String horaInicio, Usuario usuario) {
        this.ipConexion = ipConexion;
        this.horaInicio = horaInicio;
        this.usuario = usuario;
    }

    public String getIpConexion() {
        return ipConexion;
    }

    public void setIpConexion(String ipConexion) {
        this.ipConexion = ipConexion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String mostrarDetalle() {
        return "========= SESION =========\n"
                + "IP de conexion : " + ipConexion + "\n"
                + "Hora de inicio : " + horaInicio + "\n"
                + "------ Usuario -------\n"
                + usuario.mostrarInfo()
                + "==========================\n";
    }
}