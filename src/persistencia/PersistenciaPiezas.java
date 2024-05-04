package persistencia;

import piezas.Pieza;
import java.io.*;
 
public class PersistenciaPiezas {
    private static final String ARCHIVO = "piezas.txt";

    public static void guardarPieza(Pieza pieza) {
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
    public static void mostrarPiezas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                String fechaCreacion = datos[1];
                String autores = datos[2];
                String lugarCreacion = datos[3];
                boolean disponibilidadVenta = Boolean.parseBoolean(datos[4]);
                String nombrePropietarioActual = datos[5];
                String ubicacionActual = datos[6];
                double precio = Double.parseDouble(datos[7]);

                System.out.println("Título: " + titulo +
                                   ", Fecha de creación: " + fechaCreacion +
                                   ", Autores: " + autores +
                                   ", Lugar de creación: " + lugarCreacion +
                                   ", Disponibilidad de venta: " + disponibilidadVenta +
                                   ", Nombre del propietario actual: " + nombrePropietarioActual +
                                   ", Ubicación actual: " + ubicacionActual +
                                   ", Precio: " + precio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

