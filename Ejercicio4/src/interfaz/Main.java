package interfaz;
import negocio.*;

import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("=== SISTEMA INTELIGENTE DE SEGURIDAD DIGITAL ===");
        System.out.print("Nombre del analista: ");
        AnalistaSeguridad analista = new AnalistaSeguridad(sc.nextLine());
        do {
            System.out.println("\n1. Registrar amenaza detectada");
            System.out.println("2. Generar alertas automaticas");
            System.out.println("3. Consultar si existe una amenaza de un tipo");
            System.out.println("4. Mostrar amenazas registradas");
            System.out.println("5. Mostrar alertas generadas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.println("Tipo: 1. Malware  2. Phishing  3. Ataque DDoS");
                    System.out.print("Opcion: ");
                    int tipo = Integer.parseInt(sc.nextLine());
                    if (tipo >= 1 && tipo <= 3) {
                        System.out.print("Nombre de la amenaza: ");
                        String nombre = sc.nextLine();
                        System.out.print("Nivel de riesgo (1-10): ");
                        int nivel = Integer.parseInt(sc.nextLine());
                        switch (tipo) {
                            case 1:
                                System.out.print("Familia del malware: ");
                                analista.registrarAmenaza(new Malware(nombre, nivel, sc.nextLine()));
                                break;
                            case 2:
                                System.out.print("Remitente: ");
                                analista.registrarAmenaza(new Phishing(nombre, nivel, sc.nextLine()));
                                break;
                            default:
                                System.out.print("Solicitudes por segundo: ");
                                analista.registrarAmenaza(new AtaqueDDoS(nombre, nivel, Integer.parseInt(sc.nextLine())));
                                break;
                        }
                        System.out.println("Amenaza registrada.");
                    } else {
                        System.out.println("Tipo no valido.");
                    }
                    break;
                }
                case 2: {
                    int generadas = analista.generarAlertasAutomaticas();
                    System.out.println("Alertas generadas: " + generadas);
                    break;
                }
                case 3: {
                    System.out.print("Tipo a consultar (Malware / Phishing / Ataque DDoS): ");
                    String tipo = sc.nextLine();
                    if (analista.existeAmenazaDeTipo(tipo)) {
                        System.out.println("SI existe una amenaza de tipo " + tipo);
                    } else {
                        System.out.println("NO existe una amenaza de tipo " + tipo);
                    }
                    break;
                }
                case 4: {
                    if (analista.cantidadAmenazas() == 0) {
                        System.out.println("No hay amenazas registradas.");
                    } else {
                        System.out.println("\n=== AMENAZAS REGISTRADAS ===");
                        System.out.print(analista.mostrarAmenazas());
                    }
                    break;
                }
                case 5: {
                    String alertas = analista.mostrarAlertas();
                    if (alertas.equals("")) {
                        System.out.println("No hay alertas generadas.");
                    } else {
                        System.out.println("\n=== ALERTAS GENERADAS ===");
                        System.out.print(alertas);
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);

        System.out.println("Fin del programa.");
        sc.close();
    }
}
