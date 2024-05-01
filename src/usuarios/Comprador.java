package usuarios;
import java.util.ArrayList;
import java.util.Date;
import venta.Venta;
import venta.Subasta;


public class Comprador extends Usuario{
	//Atributos
	private Boolean verificacion;
	private int dinero;
	private ArrayList<Venta> infoCompras;
	
	public Comprador(String nombre, String id, String contrasenia, Date cumpleanios) {
		super(nombre, id, contrasenia);
		this.infoCompras = new ArrayList<>();
        this.verificacion = false;
        this.dinero = 0;
	}
	public Boolean getVerificacion() {
		return verificacion;
	}
	public void setVerificacion(Boolean verificacion) {
		this.verificacion = verificacion;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public ArrayList<Venta> getInfocompras() {
		return infoCompras;
	}
	public void setInfocompras(ArrayList<Venta> infocompras) {
		this.infoCompras = infocompras;
	}
	
	//Metodos
	public void realizarCompra(Venta venta) throws Exception {
        if (!verificacion) {
            throw new Exception("El comprador no está verificado.");
        }
        if (venta.getPrecio() > dinero) {
            throw new Exception("Fondos insuficientes.");
        }
        dinero -= venta.getPrecio();
        infoCompras.add(venta);
        
        
	}
	public void participarSubasta(Subasta subasta, double oferta) throws Exception {
        if (!verificacion) {
            throw new Exception("El comprador no está verificado.");
        }
        if (oferta > dinero) {
            throw new Exception("Fondos insuficientes para realizar la oferta.");
        }
	}
	
	public void agregarFondos(int cantidad) {
        dinero += cantidad;
    }
	
	public ArrayList<Venta> consultarHistorialCompras() {
        return new ArrayList<>(infoCompras);
    }
}
