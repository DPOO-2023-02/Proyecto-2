package consola;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import menu.MenuAdministrador;
import menu.MenuCajero;
import menu.MenuComprador;
import menu.MenuOperador;
import menu.MenuPropietario;
public class SistemaLogin {
	private static Map<String, String> usuarios = new HashMap<>();
	private static final String ARCHIVO_USUARIOS = "usuarios.txt";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		crearArchivoTxt(ARCHIVO_USUARIOS); 
		cargarUsuarios(); 

		try {
			while (true) {
				System.out.println("1. Iniciar sesión");
				System.out.println("2. Registrar usuario");
				System.out.println("3. Salir");
				System.out.println("Seleccione una opción:");

				int opcion = scanner.nextInt();
				scanner.nextLine(); 

				switch (opcion) {
				case 1:
					iniciarSesion(scanner);
					break;
				case 2:
					registrarUsuario(scanner);
					break;
				case 3:
					System.out.println("Saliendo del sistema...");
					guardarUsuarios(); 
					return;
				default:
					System.out.println("Opción no válida.");
				}
			}
		} finally {
			scanner.close();
		}
	}

	private static void iniciarSesion(Scanner scanner) {
		System.out.println("Ingrese su nombre de usuario:");
		String usuario = scanner.nextLine();
		System.out.println("Ingrese su contraseña:");
		String contraseña = scanner.nextLine();

		if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña)) {
			System.out.println("Inicio de sesión exitoso.");
			while (true) {
				System.out.println("Seleccione su tipo de usuario:");
				System.out.println("1. Administrador");
				System.out.println("2. Cajero");
				System.out.println("3. Operador");
				System.out.println("4. Propietario");
				System.out.println("5. Comprador");
				System.out.println("6. Cerrar Sesión");
				System.out.println("Seleccione una opción:");
				int opcion = scanner.nextInt();
				scanner.nextLine(); 

				switch (opcion) {
				case 1:
					System.out.println("Entrando a Administrador...");
					MenuAdministrador.menu();
					break;
				case 2:
					System.out.println("Entrando a Cajero ...");
					MenuCajero.menu();

					break;
				case 3:
					System.out.println("Entrando a Operador ...");
					MenuOperador.menu();

					break;
				case 4:
					 System.out.println("Entrando a Propietario...");
	                    MenuPropietario.menu();

					break;
				case 5:
					 System.out.println("Entrando a Comprador...");
	                    MenuComprador.menu();
					break;
				 case 6:
	                    System.out.println("Cerrando sesión...");
	                    return;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	    } else {
	        System.out.println("Nombre de usuario o contraseña incorrectos.");
	    }
	}

	private static void registrarUsuario(Scanner scanner) {
		System.out.println("Ingrese el nombre de usuario:");
		String nuevoUsuario = scanner.nextLine();
		System.out.println("Ingrese la contraseña:");
		String nuevaContraseña = scanner.nextLine();

		usuarios.put(nuevoUsuario, nuevaContraseña);
		guardarUsuarios(); 

		System.out.println("Usuario registrado con éxito.");
	}

	private static void cargarUsuarios() {
		try (Scanner fileScanner = new Scanner(new File(ARCHIVO_USUARIOS))) {
			while (fileScanner.hasNextLine()) {
				String linea = fileScanner.nextLine();
				String[] partes = linea.split(",");
				usuarios.put(partes[0], partes[1]);
			}
		} catch (IOException e) {
			System.err.println("Error al cargar usuarios: " + e.getMessage());
		}
	}

	private static void guardarUsuarios() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
			for (Map.Entry<String, String> entry : usuarios.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error al guardar usuarios: " + e.getMessage());
		}
	}

	private static void crearArchivoTxt(String nombreArchivo) {
		try {
			File archivo = new File(nombreArchivo);
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado: " + archivo.getName());
			} else {
				System.out.println("El archivo ya existe.");
			}
		} catch (IOException e) {
			System.out.println("Ocurrió un error al crear el archivo.");
			e.printStackTrace();
		}
	}
}