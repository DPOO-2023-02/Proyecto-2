package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import piezas.Inventario;
import piezas.Pieza;
import venta.Venta;
import venta.Subasta;

public class Cliente extends Usuario {


	private ArrayList<Venta> infoCompras;

	public Cliente(String nombre, String id, String contrasenia, int dinero) {
		super(nombre, id, contrasenia, dinero);
		this.infoCompras = new ArrayList<>();
	}

	public ArrayList<Venta> getInfoCompras() {
		return infoCompras;
	}

	public void setInfoCompras(ArrayList<Venta> infoCompras) {
		this.infoCompras = infoCompras;
	}

	public void comprarPieza(Venta venta) throws Exception {
		if (venta.getPrecio() > dinero) {
			throw new Exception("Fondos insuficientes.");
		}
		dinero -= venta.getPrecio();
		infoCompras.add(venta);
		System.out.println("Compra realizada con éxito. Restante en cartera: $" + dinero);
	}

	public static  void consultarCartera(Scanner scanner) {
		System.out.println("Saldo disponible: $" + dinero);
	}

	public static void agregarFondos() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de dinero que desea agregar a la cuenta:");
		int cantidad = scanner.nextInt();
		dinero += cantidad;
		System.out.println("Fondos añadidos. Nuevo saldo: $" + dinero);
		System.out.println("Por temas de seguridad inicie sesion nuevamente");
	}

	public static void iniciarVenta(Scanner scanner) {
		System.out.println("Listando piezas disponibles para venta directa:");
		List<Pieza> piezasDisponibles = Inventario.consultarInventario();

		piezasDisponibles.stream()
		.filter(Pieza::isDisponibilidadVenta)
		.forEach(pieza -> System.out.println("Título: " + pieza.getTitulo() +
				" - Precio: $" + pieza.getPrecio()));

		System.out.println("Ingrese el título de la pieza que desea comprar:");
		String tituloPieza = scanner.nextLine();

		Pieza piezaSeleccionada = piezasDisponibles.stream()
				.filter(p -> p.getTitulo().equalsIgnoreCase(tituloPieza) && p.isDisponibilidadVenta())
				.findFirst()
				.orElse(null);

		if (piezaSeleccionada != null) {

			realizarCompra(piezaSeleccionada);
		} else {
			System.out.println("No se encontró la pieza o no está disponible para la venta.");
		}
	}
	private static void realizarCompra(Pieza pieza) {
		// Aquí puedes agregar la lógica de verificación del comprador y confirmación de la compra.
		System.out.println("Compra realizada exitosamente para la pieza: " + pieza.getTitulo());
	}


	public Object consultarHistorialCompras() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void vender() {
		return;
	}
	public static void consultar_piezas() {
		return;
	}
	public static void piezas_vendida() {
		
	}
}
