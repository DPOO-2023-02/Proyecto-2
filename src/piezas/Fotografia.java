package piezas;

public abstract class Fotografia extends Pieza{
	public Fotografia(String id,String titulo, int anio, String[] autores, String lugarCreacion, boolean disponibilidadVenta,
			String[] propietariosAnteriores, String propietarioActual, String ubicacionActual) {
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual);
	}
	private String resolucion;
	private boolean tienecolor;
	private String relacion_imagen;

	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getRelacion_imagen() {
		return relacion_imagen;
	}

	public void setRelacion_imagen(String relacion_imagen) {
		this.relacion_imagen = relacion_imagen;
	}
	public boolean isTienecolor() {
		return tienecolor;
	}
	public void setTienecolor(boolean tienecolor) {
		this.tienecolor = tienecolor;
	}

}
