package menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import usuarios.Comprador;

public class MainComprador {

	public static void main() {
		String usuariosFile = "usuarios.txt";
		String piezasFile = "piezas.txt";	

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("comprador.txt"));

			BufferedReader usuariosReader = new BufferedReader(new FileReader(usuariosFile));
			String usuariosLine = usuariosReader.readLine();
			String[] userData = usuariosLine.split(",");
			String usuario = userData[0];
			usuariosReader.close();
			
			BufferedReader piezasReader = new BufferedReader(new FileReader(piezasFile));
			String piezasLine = piezasReader.readLine();
			String[] pieceData = piezasLine.split(",");
			String titulo = pieceData[0];
			double precio = Double.parseDouble(pieceData[7]);
			piezasReader.close();


			writer.write(usuario + "," + titulo + "," + precio + "\n");

			writer.close();

		} catch (IOException e) {
			System.err.println("Error al procesar los archivos: " + e.getMessage());
		}

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
