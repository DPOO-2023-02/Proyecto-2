package pruebas;

import static org.junit.Assert.*;
import org.junit.*;

import usuarios.Administrador;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class TestAdministrador {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testAgregarPieza() {
        String data = "Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2m x 3m\nLienzo";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Administrador.agregarPieza(scanner);
        scanner.close();

        String expectedOutput = "Pintura agregada exitosamente al inventario.";
        assertTrue(outContent.toString().contains(expectedOutput));
	}

	@Test
	public void testEliminarPieza() {
		String inputData = "Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2mx3m\nLienzo";
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));

		System.setIn(new ByteArrayInputStream("Mona Lisa\n".getBytes()));
        Administrador.eliminarPieza();

        String expectedOutput = "La pieza con título 'Mona Lisa' ha sido eliminada.";
        assertTrue(outContent.toString().contains(expectedOutput));
	}

//	@Test
//	public void testConsultarInventario() {
//		Scanner inputScanner = new Scanner("Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2m x 3m\nLienzo");
//		Administrador.agregarPieza(inputScanner);
//		inputScanner.close();
//
//		Administrador.consultarInventario();
//		String expectedOutput = "Inventario de piezas:";
//		assertTrue(outContent.toString().contains(expectedOutput));
//	}
}
