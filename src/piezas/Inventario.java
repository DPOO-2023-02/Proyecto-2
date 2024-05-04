package piezas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private static List<Pieza> piezas = new ArrayList<>();

    public static void agregarPieza(Pieza pieza) {
        piezas.add(pieza);
    }

    public static void eliminarPieza(Pieza pieza) {
        piezas.remove(pieza);
    }

    public static Pieza buscarPiezaPorTitulo(String titulo) {
        return piezas.stream()
                     .filter(p -> p.getTitulo().equals(titulo))
                     .findFirst()
                     .orElse(null);
    }

    public static List<Pieza> buscarPiezasPorAutor(String autor) {
        return piezas.stream()
                     .filter(p -> p.getAutores().contains(autor))
                     .collect(Collectors.toList());
    }

    public static void actualizarEstadoVenta(String titulo, boolean disponibilidadVenta) {
        Pieza pieza = buscarPiezaPorTitulo(titulo);
        if (pieza != null) {
            pieza.setDisponibilidadVenta(disponibilidadVenta);
        }
    }

    public static void actualizarPrecioPieza(String titulo, double nuevoPrecio) {
        Pieza pieza = buscarPiezaPorTitulo(titulo);
        if (pieza != null) {
            pieza.setPrecio(nuevoPrecio);
        }
    }

    public static List<Pieza> listarPiezasDisponiblesParaVenta() {
        return piezas.stream()
                     .filter(Pieza::isDisponibilidadVenta)
                     .collect(Collectors.toList());
    }

    public static List<Pieza> listarPiezasSubastables() {
        return piezas.stream()
                     .filter(Pieza::isSubastable)
                     .collect(Collectors.toList());
    }

    public static List<Pieza> getPiezas() {
        return new ArrayList<>(piezas);
    }

	public static void agregarObjeto(Pintura nuevaPintura) {
		// TODO Auto-generated method stub
		
	}
}
