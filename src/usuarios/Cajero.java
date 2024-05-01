package usuarios;

import java.util.Date;

public class Cajero extends Usuario{
	public Boolean pagorealizado;
	public Cajero(String nombre, String id, String contrasenia, Date cumpleanios, String rol) {
		super(nombre, id, contrasenia);
	}
	public static void Cobrar() {
		return;
	}
}
