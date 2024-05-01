package menu;
import usuarios.Cajero;
import java.util.Scanner;

public class MenuCajero {

	public static void menu() {

	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ ADMINISTRADOR ===");
	        System.out.println("1. Cobrar");
	        System.out.println("2. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine();

	        switch (opcion) {
	            case 1:
	                System.out.println("Cobrar...");
	                Cajero.Cobrar();
	                
	                break;
	            case 2:
	                System.out.println("Volviendo al menú principal...");
	                return;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}

}