package negocio;

import java.util.ArrayList;

public class Empleado {
    private String identificacion;
    private String nombre;
    private ArrayList<MetodoAutenticacion> metodos;

    public Empleado(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        metodos = new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int cantidadMetodos() {
        return metodos.size();
    }

    public void agregarMetodo(MetodoAutenticacion metodo) {
        metodos.add(metodo);
    }

    public boolean tieneMetodoSuperiorA(int umbral) {
        for (MetodoAutenticacion m : metodos) {
            if (m.getNivelSeguridad() > umbral) {
                return true;
            }
        }
        return false;
    }

    public String mostrarMetodos() {
        String resultado = "";
        for (MetodoAutenticacion m : metodos) {
            resultado += m.mostrarInformacion();
        }
        return resultado;
    }

    public String autenticar() {
        String resultado = "";
        for (MetodoAutenticacion m : metodos) {
            resultado += "- " + m.autenticar() + "\n";
        }
        return resultado;
    }

    public String mostrarInformacion() {
        return "Identificacion : " + identificacion + "\n"
                + "Nombre: " + nombre + "\n"
                + "Metodos: " + metodos.size() + "\n";
    }
}