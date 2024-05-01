package menu;

import java.util.Scanner;
import usuarios.Comprador;
public class MenuComprador {

	public static void menu() {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ COMPRADOR ===");
	        System.out.println("1. Ver el menu de compra:");
	        System.out.println("2. Consultar cartera:");
	        System.out.println("3. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (opcion) {
	            case 1:
	                System.out.println("Ver el menu de compra:...");
	                Comprador.comprarpieza();
	                break;
	            case 2:
	                System.out.println("Consultar cartera:...");
	                Comprador.cartera();
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