package persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import piezas.Pieza;

public class PersistenciaPiezas {

    private static final String PIEZAS_CSV = "piezas.csv";

    public static void guardarPiezas(List<Pieza> piezas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PIEZAS_CSV))) {
            for (Pieza pieza : piezas) {
                String linea = pieza.toCSV();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pieza> cargarPiezas() {
        List<Pieza> piezas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PIEZAS_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Pieza pieza = Pieza.fromCSV(linea);
                piezas.add(pieza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return piezas;
    }


    private static final String ARCHIVO_CSV = "piezas.csv";
    private static final Scanner scanner = new Scanner(System.in);

    public static void agregarPieza() {
        try (FileWriter writer = new FileWriter(ARCHIVO_CSV, true)) {
            // Capturar los datos de la pieza
            System.out.println("Ingrese el ID de la pieza:");
            String ID = scanner.nextLine();
            System.out.println("Ingrese el título de la pieza:");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el año de la pieza:");
            String anio = scanner.nextLine();
            // Continuar con los demás campos de la pieza...

            // Escribir los datos en el archivo CSV
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

