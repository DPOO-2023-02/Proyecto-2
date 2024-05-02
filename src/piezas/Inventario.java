package piezas;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import piezas.Pieza;
public class Inventario {
	protected static List<Pieza> piezas;

    public Inventario() {
        this.piezas = new ArrayList<>();
    }

    public static void agregarObjeto(Pieza objeto) {
    	piezas.add(objeto);
    }

    public static void eliminarObjeto(Pieza objeto) {
    	piezas.remove(objeto);
    }

    public static Pieza buscarObjeto(String nombre) {
        for (Pieza objeto : piezas) {
            if (objeto.getTitulo().equals(nombre)) {
                return objeto;
            }
        }
        return null;
    }

	public static List<Pieza> getPiezas() {
		// TODO Auto-generated method stub
		return null;
	}   
}