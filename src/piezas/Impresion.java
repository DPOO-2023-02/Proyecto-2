package piezas;

public abstract class Impresion extends Pieza{

	public Impresion(String id,String titulo, int anio, String[] autores, String lugarCreacion, boolean disponibilidadVenta,
			String[] propietariosAnteriores, String propietarioActual, String ubicacionActual) {
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual);
	}
	private String resolucion;
	private String material;
	private boolean tienecolor;
	
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public boolean isTienecolor() {
		return tienecolor;
	}
	public void setTienecolor(boolean tienecolor) {
		this.tienecolor = tienecolor;
	}
	
}
