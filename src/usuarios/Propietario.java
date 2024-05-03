package usuarios;
import java.util.ArrayList;
import java.util.Date;

public class Propietario extends Usuario{
	public ArrayList<String> listapiezas;
	public Propietario(String nombre, String id, String contrasenia, Date cumpleanios, String rol) {
		super(nombre, id, contrasenia,0);
		// TODO Auto-generated constructor stub
	}
	public static void vender() {
		return;
	}
	public static void consultar_piezas() {
		return;
	}
	public static void piezas_vendida() {
		
	}


}
