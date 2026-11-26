package interfaz;

import negocio.Sesion;
import negocio.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ASOCIACION: USUARIO Y SESION ===");
        System.out.println("\n--- Datos del usuario ---");
        System.out.print("Nombre de usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Rol: ");
        String rol = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        Usuario usuario = new Usuario(nombre, rol, correo);
        System.out.println("\n--- Datos de la sesion ---");
        System.out.print("IP de conexion: ");
        String ip = sc.nextLine();
        System.out.print("Hora de inicio (hh:mm): ");
        String hora = sc.nextLine();
        Sesion sesion = new Sesion(ip, hora, usuario);
        System.out.println("\n=== DETALLE DE LA SESION ===");
        System.out.print(sesion.mostrarDetalle());
        System.out.print("\nNuevo rol para el usuario: ");
        usuario.setRol(sc.nextLine());
        System.out.println("\n=== SESION DESPUES DE CAMBIAR EL ROL ===");
        System.out.print(sesion.mostrarDetalle());

        System.out.println("\nEl usuario existe por separado de la sesion:");
        System.out.print(usuario.mostrarInfo());

        sc.close();
    }
}
