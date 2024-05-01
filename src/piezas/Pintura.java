package piezas;

import java.util.List;

public class Pintura extends Pieza {
	 
	public Pintura(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
		List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, String material, String tamanio, String lienzo) {
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual);
	}	   
	
	private String material;
    private String tamanio;
    private String lienzo;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getLienzo() {
		return lienzo;
	}

	public void setLienzo(String lienzo) {
		this.lienzo = lienzo;
	}
}


