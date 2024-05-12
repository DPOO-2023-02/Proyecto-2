package usuarios;

public abstract class Usuario {
	private String nombre;
	private String contrasenia;
	static int dinero;

	public Usuario(String nombre, String contrasenia, int dinero) {
		this.nombre=nombre;
		this.contrasenia=contrasenia;
		Usuario.dinero=dinero;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		Usuario.dinero = dinero;
	}
	public void restarDinero(double cantidad) {
        dinero -= cantidad;
    }

}
