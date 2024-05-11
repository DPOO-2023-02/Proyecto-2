package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistencia.PersistenciaPiezas;
import piezas.Pieza;
import venta.Venta;
import venta.Subasta;

public class Comprador extends Usuario {
    
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

    public void consultarCartera() {
        System.out.println("Saldo disponible: $" + dinero);
    }

    public void agregarFondos(int cantidad) {
        dinero += cantidad;
        System.out.println("Fondos añadidos. Nuevo saldo: $" + dinero);
    }
    
    public void iniciarVenta(Scanner scanner) {
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
}
