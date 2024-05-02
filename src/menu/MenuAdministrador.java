package menu;

import java.util.Scanner;
import usuarios.Administrador;

public class MenuAdministrador {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("=== MENÚ ADMINISTRADOR ===");
                System.out.println("1. Agregar Pieza a inventario");
                System.out.println("2. Eliminar Pieza de inventario");
                System.out.println("3. Consultar Inventario");
                System.out.println("4. Aprobar Pago");
                System.out.println("5. Modificar Inventario");
                System.out.println("6. Volver al menú principal");
                System.out.println("Seleccione una opción:");
                
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        Administrador.agregarPieza(scanner);
                        break;
                    case 2:
                        Administrador.eliminarPieza(scanner);
                        break;
                    case 3:
                        Administrador.consultarInventario();
                        break;
                    case 4:
                        Administrador.aprobarPago(scanner);
                        break;
                    case 5:
                        Administrador.modificarInventario(scanner);
                        break;
                    case 6:
                        System.out.println("Volviendo al menú principal...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
