package menu;
import java.util.Scanner;
import usuarios.Propietario;
public class MainPropietario {

    public static void main() {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ PROPIETARIO ===");
	        System.out.println("1. Vender o Subastar Pieza");
	        System.out.println("2. Mis Piezas");
	        System.out.println("3. Piezas Vendidas");
	        System.out.println("4. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consume the remaining newline character

	        switch (opcion) {
	            case 1:
	                System.out.println("Vender o Subastar Pieza...");
	                Propietario.vender();
	                break;
	            case 2:
	                System.out.println("Mis Piezas...");
	                Propietario.consultar_piezas();
	                break;
	            case 3:
	                System.out.println("Piezas Vendidas...");
	                Propietario.piezas_vendida();
	                break;
	            case 4:
	                System.out.println("Volviendo al menú principal...");
	                return;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}

}