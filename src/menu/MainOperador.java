package menu;

import java.util.Scanner;
import usuarios.Operador;
public class MainOperador {

	public static void menu() {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ OPERADOR ===");
	        System.out.println("1. Cambiar estado pieza");
	        System.out.println("2. Registrar Pujas");
	        System.out.println("3. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consume the remaining newline character

	        switch (opcion) {
	            case 1:
	                System.out.println("Cambiar estado pieza...");
	                Operador.cambiar_estado_piezas();
	                break;
	            case 2:
	                System.out.println("Registrar Pujas...");
	                Operador.registrarpujas();
	                break;
	            case 3:
	                System.out.println("Volviendo al menú principal...");
	                return;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}

}