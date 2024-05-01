package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class IPersistenciaLogin {
	
	
	public static ArrayList<String> read_info () {
		
		ArrayList<String> datos = new ArrayList<>();
		
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
 
        try {

            archivo = new File("usuario.csv");

            fr = new FileReader(archivo);
  
            br = new BufferedReader(fr);
 
            while ((linea = br.readLine()) != null) {
            	
            	String[] strings = linea.split(";");
            	
            	
            	for (int i = 0; i < strings.length; i++) {
            		datos.add(strings[i]);
            		
            		System.out.println(strings[i]);
				}
 
            }
            
            return datos;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return null; 
	}
	
	
	public static String formatter(String nombre, String apellido, String cedula, String usuario, String contrasena, String contacto, int ingresos, String rol, String UltimaActualizacion) {


	    String line = nombre + ";" + contrasena;

	    return line;
	}
	
    public static void add_info(String string) {
    	
    	
    	BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            File file = new File("usuario.csv");
            
            if (!file.exists()) {
                file.createNewFile();
            }
           
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(string);
            System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                   
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    	

	}
    public static List<String> read_info(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

}