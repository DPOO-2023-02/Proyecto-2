package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import piezas.Inventario;
import piezas.Pieza;
import venta.Venta;
import venta.Subasta;

public class Comprador extends Usuario {
    
    private ArrayList<Venta> infoCompras;
    
    
    static int dinero = 0;
 
    
    public Comprador(String nombre, String id, String contrasenia, int dinero) {
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

    public static void consultarCartera(Scanner scanner) {
        System.out.println("Saldo disponible: $" + dinero);
    }

    public static void agregarFondos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dinero que desea agregar a la cuenta:");
        int cantidad = scanner.nextInt();
        dinero += cantidad;
        System.out.println("Fondos añadidos. Nuevo saldo: $" + dinero);
        System.out.println("Por motivos de seguridad inicie nuevamente sesion" );
    }
    
    public static void iniciarVenta(Scanner scanner) {
        System.out.println("Listando piezas disponibles:");
        List<Pieza> piezasDisponibles = PersistenciaPiezas.consultarInventario();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.isDisponibilidadVenta()) {
                System.out.println(" - Título: " + pieza.getTitulo() + " - Precio: $" + pieza.getPrecio());
            }
        }

        System.out.println("Ingrese el ID de la pieza que desea comprar:");
        String idPieza = scanner.nextLine();
        Pieza piezaSeleccionada = piezasDisponibles.stream()
                .filter(p -> p.getId().equals(idPieza) && p.isDisponibilidadVenta())
                .findFirst()
                .orElse(null);

        if (piezaSeleccionada != null) {
            if (piezaSeleccionada.isSubastable()) {
                Subasta subasta = new Subasta(piezaSeleccionada.getPrecio(), piezaSeleccionada.getPrecio() + 100, piezaSeleccionada);
                subasta.registrarParticipante(this);
                System.out.println("Participación en subasta iniciada para la pieza: " + piezaSeleccionada.getTitulo());
            } else {
                try {
                    boolean pagoConfirmado = Cajero.ConfirmarPago(this, piezaSeleccionada.getPrecio(), false);
                    if (pagoConfirmado) {
                        System.out.println("Compra realizada exitosamente para la pieza: " + piezaSeleccionada.getTitulo());
                    } else {
                        System.out.println("No se pudo completar la compra debido a fondos insuficientes.");
                    }
                } catch (Exception e) {
                    System.out.println("Error en la compra: " + e.getMessage());
                }
            }
        } else {
            System.out.println("La pieza seleccionada no está disponible o no existe.");
        }
    }

	public Object consultarHistorialCompras() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
}
=======


	private ArrayList<Venta> infoCompras;

	public Comprador(String nombre, String id, String contrasenia, int dinero) {
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

	public static void consultarCartera(Scanner scanner) {
		System.out.println("Saldo disponible: $" + dinero);
	}

	public static void agregarFondos() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de dinero que desea agregar a la cuenta:");
		int cantidad = scanner.nextInt();
		dinero += cantidad;
		System.out.println("Fondos añadidos. Nuevo saldo: $" + dinero);
	}

	public static void iniciarVenta(Scanner scanner) {
		System.out.println("Listando piezas disponibles para venta directa:");
		List<Pieza> piezasDisponibles = Inventario.consultarInventario();

		// Filtrar y mostrar piezas disponibles para venta directa
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
			// Aquí debes integrar la lógica para realizar la compra, como llamar a un método que maneje la transacción.
			realizarCompra(piezaSeleccionada);
		} else {
			System.out.println("No se encontró la pieza o no está disponible para la venta.");
		}
	}

	// Método para simular la compra de una pieza.
	private void realizarCompra(Pieza pieza) {
		// Aquí puedes agregar la lógica de verificación del comprador y confirmación de la compra.
		System.out.println("Compra realizada exitosamente para la pieza: " + pieza.getTitulo());
	}


public Object consultarHistorialCompras() {
	// TODO Auto-generated method stub
	return null;
}
}
>>>>>>> 5f1b4d96583ca493adb9eb8a3d1a1cb447c39b8f
