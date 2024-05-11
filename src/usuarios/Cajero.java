package usuarios;

import java.util.Date;

public class Cajero extends Usuario{
	public Boolean pagorealizado;
	public Cajero(String nombre, String id, String contrasenia, Date cumpleanios, String rol) {
		super(nombre, id, contrasenia,0);
	}
	public static boolean ConfirmarPago(Usuario usuario, double cantidad, boolean esSubasta) {
		if (usuario.getDinero() >= cantidad) {
			usuario.restarDinero(cantidad);
			if (esSubasta) {
				System.out.println("Pago confirmado desde subasta.");
			} else {
				System.out.println("Pago confirmado desde venta normal.");
			}
			return true;
		} else {
			System.out.println("Fondos insuficientes.");
			return false;
		}
	}
	public static void CambiarComprador() {
		// TODO Auto-generated method stub

	}
//no
}
