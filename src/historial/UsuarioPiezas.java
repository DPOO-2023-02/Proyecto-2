package historial;

import java.io.*;
import java.util.*;

public class UsuarioPiezas {

    private Map<String, List<String>> piezasPorComprador = new HashMap<>();
    private Set<String> usuariosValidos = new HashSet<>();

    public static void main(String[] args) {
        UsuarioPiezas admin = new UsuarioPiezas();
        admin.cargarUsuarios("Usuarios.txt");
        admin.cargarPiezas("Piezas.txt");
        admin.escribirArchivo("Comprador.txt");
    }

    public void cargarUsuarios(String rutaUsuarios) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaUsuarios));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(", ");
                String usuario = datos[0].toLowerCase();
                String rol = datos[2];
                if (rol.equals("comprador") || rol.equals("propietario")) {
                    usuariosValidos.add(usuario);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarPiezas(String rutaPiezas) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaPiezas));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String propietario = datos[5].toLowerCase();
                if (usuariosValidos.contains(propietario)) {
                    piezasPorComprador.computeIfAbsent(datos[5], k -> new ArrayList<>()).add(datos[0] + ", " + datos[7]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo(String rutaSalida) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida));
            for (Map.Entry<String, List<String>> entry : piezasPorComprador.entrySet()) {
                String piezas = String.join("; ", entry.getValue());
                pw.println(entry.getKey() + ", [" + piezas + "]");
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

