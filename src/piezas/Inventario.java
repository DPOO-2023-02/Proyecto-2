package piezas;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    protected static List<Pieza> piezas = new ArrayList<>();

    public Inventario() {
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
        return piezas; 
    }
}
