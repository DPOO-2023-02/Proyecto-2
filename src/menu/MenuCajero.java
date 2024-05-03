package menu;
import usuarios.Cajero;
import java.util.Scanner;

public class MenuCajero {

	public static void menu() {

	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ CAJERO ===");
	        System.out.println("1. Confirmar pago");
	        System.out.println("2. Cambiar comprador");
	        System.out.println("3. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine();

	        switch (opcion) {
	            case 1:
	                System.out.println("Confirmar pago...");
	                Cajero.ConfirmarPago();
	                break;
	            case 2:
	                System.out.println("Cambiando comprador...");
	                Cajero.ConfirmarPago();
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