package pruebas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import usuarios.Administrador;
import piezas.Inventario;
import piezas.Pieza;
import persistencia.PersistenciaPiezas;

public class TestAdministrador {

    @BeforeEach
    public void setUp() {
        Administrador admin = new Administrador("Admin", "001", "adminPass", true);
    }

    @Test
    public void testAgregarPieza() {
        // Preparar el scanner para simular la entrada del usuario
        String data = "La Gioconda\n" +
                      "1503\n" +
                      "Leonardo da Vinci\n" +
                      "Florence\n" +
                      "true\n" +
                      "Museo del Louvre\n" +
                      "Paris\n" +
                      "6500000\n" +
                      "1\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Administrador.agregarPieza(scanner);
        } finally {
            System.setIn(stdin);
        }

        // Suponiendo que hay un método para obtener la última pieza añadida a la persistencia
        Pieza lastAddedPieza = Inventario.consultarInventario().get(Inventario.consultarInventario().size() - 1);
        assertNotNull(lastAddedPieza);
        assertEquals("La Gioconda", lastAddedPieza.getTitulo());
        assertEquals(6500000, lastAddedPieza.getPrecio());
    }

    @Test
    public void testCrearPintura() {
        String data = "The Starry Night\n" +
                      "1889\n" +
                      "Vincent van Gogh\n" +
                      "Saint-Rémy-de-Provence\n" +
                      "false\n" +
                      "Museum of Modern Art\n" +
                      "New York\n" +
                      "100000000\n" +
                      "oil paint\n" +
                      "73.7 cm × 92.1 cm\n" +
                      "canvas\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Administrador.crearPintura(scanner, "The Starry Night", "1889", "Vincent van Gogh", "Saint-Rémy-de-Provence", false, "Museum of Modern Art", "New York", 100000000);
        } finally {
            System.setIn(stdin);
        }

        // Verificar que la pieza fue agregada correctamente
        Pieza lastAddedPieza = Inventario.consultarInventario().get(Inventario.consultarInventario().size() - 1);
        assertEquals("The Starry Night", lastAddedPieza.getTitulo());
        assertEquals(100000000, lastAddedPieza.getPrecio());
        assertFalse(lastAddedPieza.isDisponibilidadVenta());
    }

    @Test
    public void testBuscarPiezaPorTitulo() {
        String expectedTitle = "La Gioconda";
        Administrador.buscarPiezaPorTitulo(expectedTitle);
        // No es posible verificar la salida de consola directamente,
        // deberíamos esperar que el sistema de persistencia devuelva una pieza con el título buscado
        // Este es un ejemplo de cómo podrías configurarlo
        Pieza pieza = Inventario.buscarPiezaPorTitulo(expectedTitle);
        assertNotNull(pieza);
        assertEquals(expectedTitle, pieza.getTitulo());
    }

    // Más pruebas pueden ser añadidas siguiendo el patrón de arriba
}
