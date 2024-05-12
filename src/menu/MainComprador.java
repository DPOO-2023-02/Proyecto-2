package menu;

import java.util.Scanner;
import usuarios.Comprador;

public class MainComprador {

	public static void main() {
		
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("=== MENÚ COMPRADOR ===");
			System.out.println("1. Ver el menú de compra");
			System.out.println("2. Consultar cartera");
			System.out.println("3. Agregar fondos");
			System.out.println("4. Volver al menú principal");
			System.out.println("Seleccione una opción:");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				Comprador.iniciarVenta(scanner);
				break;
			case 2:
				Comprador.consultarCartera(scanner);
				break;
			case 3:
				Comprador.agregarFondos();
				return;
			case 4:
				System.out.println("Volviendo al menú principal...");
				return;
			default:
				System.out.println("Opción no válida.");
				break;
			}
		}
	}

}
