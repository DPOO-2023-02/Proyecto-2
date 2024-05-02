package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import piezas.Pieza;

public class PersistenciaPiezas {

    private static final String ARCHIVO_TXT = "piezas.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void guardarPiezas(List<Pieza> piezas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_TXT))) {
            for (Pieza pieza : piezas) {
                String linea = pieza.getId() + "," + pieza.getTitulo() + "," + pieza.getAnio(); // Suponiendo que `getId()`, `getTitulo()` y `getAnio()` son métodos de la clase `Pieza`
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pieza> cargarPiezas() {
        List<Pieza> piezas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_TXT))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    Pieza pieza = new Pieza(partes[0], partes[1], partes[2]); // Suponiendo que el constructor de `Pieza` toma el ID, el título y el año como argumentos
                    piezas.add(pieza);
                } else {
                    System.err.println("Formato incorrecto en línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return piezas;
    }

    public static void agregarPieza() {
        try (FileWriter writer = new FileWriter(ARCHIVO_TXT, true)) {
            // Capturar los datos de la pieza
            System.out.println("Ingrese el ID de la pieza:");
            String ID = scanner.nextLine();
            System.out.println("Ingrese el título de la pieza:");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el año de la pieza:");
            String anio = scanner.nextLine();
            // Continuar con los demás campos de la pieza...

            // Escribir los datos en el archivo TXT
            writer.append(ID).append(",").append(titulo).append(",").append(anio); // Continuar con los demás campos...

            writer.append("\n"); // Agregar un salto de línea al final de la línea
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        agregarPieza();
    }
}

