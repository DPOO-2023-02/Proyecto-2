package piezas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private static List<Pieza> piezas = new ArrayList<>();
    private static final String ARCHIVO = "piezas.txt";

    public static void agregarPieza(Pieza pieza) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(pieza.getTitulo() + "," +
                    pieza.getAnio() + "," +
                    pieza.getAutores() + "," +
                    pieza.getLugarCreacion() + "," +
                    pieza.isDisponibilidadVenta() + "," +
                    pieza.getPropietarioActual() + "," +
                    pieza.getUbicacionActual() + "," +
                    pieza.getPrecio() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarPieza(String titulo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            StringBuilder contenidoNuevo = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(titulo)) {
                    contenidoNuevo.append(linea).append("\n");
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
                writer.write(contenidoNuevo.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarPiezas(List<Pieza> piezas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Pieza pieza : piezas) {
                writer.write(pieza.getTitulo() + "," +
                        pieza.getAnio() + "," +
                        pieza.getAutores() + "," +
                        pieza.getLugarCreacion() + "," +
                        pieza.isDisponibilidadVenta() + "," +
                        pieza.getPropietarioActual() + "," +
                        pieza.getUbicacionActual() + "," +
                        pieza.getPrecio() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pieza> consultarInventario() {
        piezas.clear(); // Clear the current in-memory list
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                piezas.add(new Pieza(
                    datos[0], // titulo
                    datos[1], // anio
                    datos[2], // autores
                    datos[3], // lugarCreacion
                    Boolean.parseBoolean(datos[4]), // disponibilidadVenta
                    new ArrayList<>(), // propietariosAnteriores
                    datos[5], // propietarioActual
                    datos[6], // ubicacionActual
                    Double.parseDouble(datos[7]) // precio
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(piezas);
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
            guardarPiezas(piezas); // Update file to reflect the change
        }
    }

    public static void actualizarPrecioPieza(String titulo, double nuevoPrecio) {
        Pieza pieza = buscarPiezaPorTitulo(titulo);
        if (pieza != null) {
            pieza.setPrecio(nuevoPrecio);
            guardarPiezas(piezas); // Update file to reflect the change
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
}
