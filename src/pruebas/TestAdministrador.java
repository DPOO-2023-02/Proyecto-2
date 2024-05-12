package pruebas;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import usuarios.Administrador;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestAdministrador {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream systemInBackup = (ByteArrayInputStream) System.in;
    private Administrador admin;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        admin = new Administrador("juanito", "123", 100);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(systemInBackup);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    public void testAgregarPieza() {
        String inputData = "Mona Lisa\n" +
                           "1503\n" +
                           "Leonardo da Vinci\n" +
                           "Italia\n" +
                           "true\n" +
                           "galeria\n" +
                           "sala principal\n" +
                           "1000000\n" +
                           "1\n";
        provideInput(inputData);
        Administrador.agregarPieza(new Scanner(System.in));
        assertTrue(outContent.toString().contains("Pintura agregada exitosamente al inventario."));
    }

    @Test
    public void testBuscarPiezaPorTitulo() {
        admin.buscarPiezaPorTitulo("Mona Lisa");
        assertTrue(outContent.toString().contains("Pieza encontrada:"));
    }

    @Test
    public void testConsultarInventario() {
        admin.consultarInventario();
        assertTrue(outContent.toString().contains("Inventario de piezas:"));
    }

    @Test
    public void testEliminarPieza() {
        String inputData = "Mona Lisa\n";
        provideInput(inputData);
        admin.eliminarPieza();
        assertTrue(outContent.toString().contains("La pieza con título 'Mona Lisa' ha sido eliminada."));
    }
}
