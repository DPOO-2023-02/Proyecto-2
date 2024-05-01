package usuarios;
import java.util.Date;

import piezas.Inventario;
import piezas.Pieza;

public class Administrador extends Usuario {
	public Boolean verificado;

	public Administrador(String nombre, String id, String contrasenia, Boolean verificado) {
		super(nombre, id, contrasenia);
		this.verificado = verificado;
	}

	public void agregarObjetoAlInventario(Pieza objeto) {
		Inventario.agregarObjeto(objeto);
	}


	public void modificarObjetoEnInventario(String nombreObjeto, Pieza nuevoObjeto) {
		Pieza objetoExistente = Inventario.buscarObjeto(nombreObjeto);
		if (objetoExistente != null) {
			Inventario.eliminarObjeto(objetoExistente);
			Inventario.agregarObjeto(nuevoObjeto);
		}
	}

	public static void EliminarPieza(Pieza objeto) {
		Inventario.eliminarObjeto(objeto);

	}
	public static void ConsultarInventario() {
		return;
	}
	public static void AprobarPago() {
		return;
	}


}


