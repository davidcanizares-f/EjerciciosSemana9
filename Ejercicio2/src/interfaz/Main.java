package interfaz;

import negocio.Evento;
import negocio.Servidor;

import java.util.Scanner;

public class Main {
    private static String leerNivel(Scanner sc) {
        String nivel;
        do {
            System.out.print("Nivel de riesgo (ALTO/MEDIO/BAJO): ");
            nivel = sc.nextLine().trim().toUpperCase();
        } while (!nivel.equals("ALTO") && !nivel.equals("MEDIO") && !nivel.equals("BAJO"));
        return nivel;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 5;
        Evento[] eventos = new Evento[CANTIDAD];

        System.out.println("=== AGREGACION: SERVIDOR Y LOG DE EVENTOS ===");
        System.out.println("Registre " + CANTIDAD + " eventos.");

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println("\n--- Evento " + (i + 1) + " ---");
            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();
            String nivel = leerNivel(sc);
            eventos[i] = new Evento(descripcion, nivel);
        }

        System.out.print("\nNombre del servidor: ");
        Servidor servidor = new Servidor(sc.nextLine(), eventos);

        System.out.println("\n=== EVENTOS DE " + servidor.getNombreServidor().toUpperCase() + " ===");
        System.out.print(servidor.mostrarEventos());

        System.out.println("\nEventos de riesgo ALTO: " + servidor.contarPorNivel("ALTO"));
        System.out.println("Eventos de riesgo MEDIO: " + servidor.contarPorNivel("MEDIO"));
        System.out.println("Eventos de riesgo BAJO: " + servidor.contarPorNivel("BAJO"));

        System.out.println("\nCambie el riesgo del primer evento (el evento existe fuera del servidor).");
        eventos[0].setNivelRiesgo(leerNivel(sc));

        System.out.println("\n=== EVENTOS DESPUES DEL CAMBIO ===");
        System.out.print(servidor.mostrarEventos());

        sc.close();
    }
}
