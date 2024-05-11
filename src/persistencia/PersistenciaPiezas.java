package persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import piezas.Pieza;

public class PersistenciaPiezas {
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
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int anio = Integer.parseInt(datos[1]);
                String autores = datos[2];
                String lugarCreacion = datos[3];
                boolean disponibilidadVenta = Boolean.parseBoolean(datos[4]);
                String nombrePropietarioActual = datos[5];
                String ubicacionActual = datos[6];
                double precio = Double.parseDouble(datos[7]);

                System.out.println(" Título: " + titulo +
                        ",\n Año de creación: " + anio +
                        ",\n Autores: " + autores +
                        ",\n Lugar de creación: " + lugarCreacion +
                        ",\n Disponibilidad de venta: " + disponibilidadVenta +
                        ",\n Nombre del propietario actual: " + nombrePropietarioActual +
                        ",\n Ubicación actual: " + ubicacionActual +
                        ",\n Precio: " + precio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
}
