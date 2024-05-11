package usuarios;

public abstract class Usuario {
	private String nombre;
	private String id;
	private String contrasenia;
	protected static int dinero;

	public Usuario(String nombre, String id, String contrasenia, int dinero) {
		this.nombre=nombre;
		this.id=id;
		this.contrasenia=contrasenia;
		Usuario.dinero=dinero;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		this.dinero = dinero;
	}
	public void restarDinero(double cantidad) {
        dinero -= cantidad;
    }

}
