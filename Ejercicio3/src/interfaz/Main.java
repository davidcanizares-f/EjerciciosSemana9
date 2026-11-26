package interfaz;
import negocio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Empleado buscarEmpleado(ArrayList<Empleado> empleados, String id) {
        for (Empleado e : empleados) {
            if (e.getIdentificacion().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private static Empleado pedirEmpleado(Scanner sc, ArrayList<Empleado> empleados) {
        System.out.print("Identificacion del empleado: ");
        String id = sc.nextLine();
        Empleado e = buscarEmpleado(empleados, id);
        if (e == null) {
            System.out.println("No existe un empleado con identificacion " + id);
        }
        return e;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        int opcion;

        System.out.println("=== CONTROL DE ACCESO BIOMETRICO ===");

        do {
            System.out.println("\n1. Registrar empleado");
            System.out.println("2. Asignar metodo de autenticacion");
            System.out.println("3. Consultar metodo sobre un umbral de seguridad");
            System.out.println("4. Mostrar metodos de un empleado");
            System.out.println("5. Simular autenticacion de un empleado");
            System.out.println("6. Listar empleados");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.print("Identificacion: ");
                    String id = sc.nextLine();
                    if (buscarEmpleado(empleados, id) != null) {
                        System.out.println("Ya existe un empleado con esa identificacion.");
                    } else {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        empleados.add(new Empleado(id, nombre));
                        System.out.println("Empleado registrado.");
                    }
                    break;
                }
                case 2: {
                    Empleado e = pedirEmpleado(sc, empleados);
                    if (e != null) {
                        System.out.println("Metodo: 1. Huella digital  2. Reconocimiento facial  3. Token de seguridad");
                        System.out.print("Opcion: ");
                        int tipo = Integer.parseInt(sc.nextLine());
                        if (tipo >= 1 && tipo <= 3) {
                            System.out.print("Nivel de seguridad (1-10): ");
                            int nivel = Integer.parseInt(sc.nextLine());
                            switch (tipo) {
                                case 1:
                                    System.out.print("Dedo registrado: ");
                                    e.agregarMetodo(new HuellaDigital(nivel, sc.nextLine()));
                                    break;
                                case 2:
                                    System.out.print("Porcentaje de coincidencia: ");
                                    e.agregarMetodo(new ReconocimientoFacial(nivel, Double.parseDouble(sc.nextLine())));
                                    break;
                                default:
                                    System.out.print("Codigo del token: ");
                                    e.agregarMetodo(new TokenSeguridad(nivel, sc.nextLine()));
                                    break;
                            }
                            System.out.println("Metodo asignado a " + e.getNombre() + ".");
                        } else {
                            System.out.println("Tipo de metodo no valido.");
                        }
                    }
                    break;
                }
                case 3: {
                    Empleado e = pedirEmpleado(sc, empleados);
                    if (e != null) {
                        System.out.print("Umbral de seguridad: ");
                        int umbral = Integer.parseInt(sc.nextLine());
                        if (e.tieneMetodoSuperiorA(umbral)) {
                            System.out.println(e.getNombre() + " SI tiene un metodo con nivel superior a " + umbral);
                        } else {
                            System.out.println(e.getNombre() + " NO tiene un metodo con nivel superior a " + umbral);
                        }
                    }
                    break;
                }
                case 4: {
                    Empleado e = pedirEmpleado(sc, empleados);
                    if (e != null) {
                        if (e.cantidadMetodos() == 0) {
                            System.out.println(e.getNombre() + " no tiene metodos asignados.");
                        } else {
                            System.out.println("\nMetodos de " + e.getNombre() + ":");
                            System.out.print(e.mostrarMetodos());
                        }
                    }
                    break;
                }
                case 5: {
                    Empleado e = pedirEmpleado(sc, empleados);
                    if (e != null) {
                        if (e.cantidadMetodos() == 0) {
                            System.out.println(e.getNombre() + " no tiene metodos asignados.");
                        } else {
                            System.out.println("\nAutenticacion de " + e.getNombre() + ":");
                            System.out.print(e.autenticar());
                        }
                    }
                    break;
                }
                case 6: {
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    }
                    for (Empleado e : empleados) {
                        System.out.print(e.mostrarInformacion());
                        System.out.println("----------------------------");
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
