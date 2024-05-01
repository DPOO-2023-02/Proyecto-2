package usuarios;

public abstract class Usuario {
	private String nombre;
	private String id;
	private String contrasenia;

	public Usuario(String nombre, String id, String contrasenia) {
		this.setNombre(nombre);
		this.setId(id);
		this.setContrasenia(contrasenia);

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
}