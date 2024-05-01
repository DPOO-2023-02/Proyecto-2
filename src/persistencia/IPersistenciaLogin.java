package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class IPersistenciaLogin {
    public static void escribirArchivo(String rutaArchivo, String usuario, String contraseña) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write("Usuario: " + usuario);
            writer.newLine();
            writer.write("Contraseña: " + contraseña);
            writer.newLine();
            writer.write("--------------------");
            writer.newLine();
            System.out.println("Credenciales guardadas con éxito en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


    public static void leertxt(String[] args) {
        String rutaArchivo = "credenciales.txt";
        leerArchivo(rutaArchivo);
    }

    public static void leerArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}