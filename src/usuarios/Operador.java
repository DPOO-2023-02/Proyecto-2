package usuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import piezas.Pieza;
import venta.Subasta;

public class Operador extends Usuario {
	protected ArrayList<Double> listaPujas;
	private Subasta subastaActual;
	private Pieza pieza;
	
	public Operador(String nombre, String id, String contrasenia) {
		super(nombre, id, contrasenia);
		this.listaPujas = new ArrayList<Double>();
		this.subastaActual = new Subasta(Subasta.valorInicial , Subasta.valorMinimo, pieza);
	}
	
	
	public void registrarPuja(double monto) {
        listaPujas.add(monto);
        Collections.sort(listaPujas, Collections.reverseOrder());
        while (listaPujas.size() > 3) {
            listaPujas.remove(listaPujas.size() - 1);
        }
    }
	public ArrayList<Double> getListaPujas() {
        return new ArrayList<>(listaPujas); 
    }
	
	public void iniciarSubasta(Pieza pieza, double valorInicial, double valorMinimo) {
        this.subastaActual = new Subasta(valorInicial, valorMinimo, pieza);
        subastaActual.establecerPiezaEnSubasta(pieza); 
        subastaActual.abrirSubasta();
        this.listaPujas.clear();
	}
}
