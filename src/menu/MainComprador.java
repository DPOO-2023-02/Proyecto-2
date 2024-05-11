package menu;

import java.util.Scanner;
import usuarios.Comprador;

public class MainComprador {

    public static void menu(Comprador comprador) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("=== MENÚ COMPRADOR ===");
            System.out.println("1. Ver el menú de compra");
            System.out.println("2. Consultar cartera");
            System.out.println("3. Volver al menú principal");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuCompra(comprador, scanner);
                    break;
                case 2:
                    consultarCartera(comprador);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void menuCompra(Comprador comprador, Scanner scanner) {
        System.out.println("Accediendo al menú de compra...");
        comprador.iniciarVenta(scanner);
    }

    private static void consultarCartera(Comprador comprador) {
        System.out.println("Consultando cartera...");
        System.out.println("Balance disponible: $" + comprador.getDinero());
        System.out.println("Historial de compras:");
        comprador.consultarHistorialCompras().forEach(venta ->
            System.out.println("Pieza: " + venta.getPieza().getTitulo() + ", Precio: " + venta.getPrecio() + ", Fecha: " + venta.getFechaCompra())
        );
    }
}
