package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import usuarios.Administrador;
import piezas.Escultura;
import piezas.Inventario;
import piezas.Pieza;
import piezas.Pintura;

public class MenuAdministrador {

    private static Administrador usuario;

    public void setUsuario(Administrador usuario) {
        MenuAdministrador.usuario = usuario;
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
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
            		agregarPieza(scanner);
                break;
            case 2:
                System.out.println("Eliminar Pieza de inventario...");
                // Lógica para eliminar una pieza
                break;
            case 3:
                System.out.println("Consultar Inventario...");
                // Lógica para consultar el inventario
                break;
            case 4:
                System.out.println("Aprobar Pago...");
                // Lógica para aprobar pagos
                break;
            case 5:
                System.out.println("Modificar Inventario...");
                // Lógica para modificar el inventario
                break;
            case 6:
                System.out.println("Volviendo al menú principal...");
                scanner.close();
                return;
            default:
                System.out.println("Opción no válida.");
            }
        }
    }	
    private static void agregarPieza(Scanner scanner) {
        System.out.println("Introduzca el título de la pieza: ");
        String titulo = scanner.nextLine();

        System.out.println("Introduzca el año de creación de la pieza: ");
        String anio = scanner.nextLine();

        System.out.println("Introduzca el/los autores de la pieza: ");
        String autores = scanner.nextLine();

        System.out.println("Introduzca el lugar de creación de la pieza: ");
        String lugarCreacion = scanner.nextLine();

        System.out.println("Introduzca la disponibilidad de la pieza (true/false): ");
        boolean disponibilidadVenta = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Introduzca el nombre del propietario actual de la pieza: ");
        String propietarioActual = scanner.nextLine();

        System.out.println("Introduzca la ubicación actual de la pieza: ");
        String ubicacionActual = scanner.nextLine();

        
        System.out.println("Seleccione el tipo de pieza a crear:");
        System.out.println("1. Pintura");
        System.out.println("2. Escultura");
        System.out.println("3. Video");
        System.out.println("4. Fotografía");
        System.out.println("5. Impresión");
        System.out.print("Ingrese su opción: ");
        int tipoPieza = scanner.nextInt();
        scanner.nextLine();  

        switch (tipoPieza) {
            case 1:
            	System.out.println("Creando una nueva Pintura...");
                
                System.out.print("Ingrese el material: ");
        	    String material = scanner.nextLine();
        	    System.out.print("Ingrese el tamaño: ");
        	    String tamanio = scanner.nextLine();
        	    System.out.print("Ingrese el tipo de lienzo: ");
        	    String lienzo = scanner.nextLine();
        	    
        	    Pintura nuevaPintura = new Pintura(titulo, anio, autores, lugarCreacion, disponibilidadVenta, 
        	    		new ArrayList<>(), propietarioActual, ubicacionActual, material, tamanio, lienzo);
                break;
            
            case 2:
            	System.out.println("Creando una nueva Escultura...");
                
                System.out.print("Ingrese los materiales utilizados: ");
                String material1 = scanner.nextLine();
                
                System.out.print("Ingrese detalles de instalación: ");
                String detallesInstalacion = scanner.nextLine();
                
                System.out.print("¿Requiere electricidad? (true/false): ");
                boolean requiereElectricidad = Boolean.parseBoolean(scanner.nextLine());
                
                System.out.print("Ingrese el peso: ");
                String peso = scanner.nextLine();
                
                Escultura nuevaEscultura = new Escultura(titulo, anio, autores, lugarCreacion, disponibilidadVenta, 
        	    		new ArrayList<>(), propietarioActual, ubicacionActual, material1, detallesInstalacion, 
        	    		requiereElectricidad, peso);
                
                break;
            
            case 3:
            	System.out.println("Creando un nuevo Video...");
            	
                System.out.print("Ingrese la resolución del video: ");
                String resolucion = scanner.nextLine();
                
                System.out.print("¿Tiene audio? (true/false): ");
                boolean audio = Boolean.parseBoolean(scanner.nextLine());
                
                System.out.print("Ingrese la relación de imagen: ");
                String relacionImagen = scanner.nextLine();
                break;
            
            case 4:
                crearFotografia(scanner); // asumiendo que este método implementa la creación de Fotografía
                break;
            
            case 5:
                crearImpresion(scanner); // asumiendo que este método implementa la creación de Impresión
                break;
            
            default:
                System.out.println("Tipo de pieza no válido.");
                break;
        }
    }

}
