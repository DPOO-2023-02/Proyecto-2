package piezas;

public abstract class Video extends Pieza {

	public Video(String id,String titulo, int anio, String[] autores, String lugarCreacion, boolean disponibilidadVenta,
			String[] propietariosAnteriores, String propietarioActual, String ubicacionActual) {
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual);
		
	}
	private String resolucion;
	private String relacion_imagen;
	private boolean audio;
	private boolean tienecolor;
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
	public boolean isAudio() {
		return audio;
	}
	public void setAudio(boolean audio) {
		this.audio = audio;
	}
	public boolean isColor() {
		return tienecolor;
	}
	public void setColor(boolean color) {
		this.tienecolor = color;
	}

}
