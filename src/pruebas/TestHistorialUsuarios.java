package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import historial.UsuarioPiezas;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TestHistorialUsuarios {

    private final String rutaUsuarios = "testUsuarios.txt";
    private final String rutaPiezas = "testPiezas.txt";
    private final String rutaSalida = "testClientes.txt";
    private UsuarioPiezas admin;

    @BeforeEach
    void setUp() throws IOException {
        admin = new UsuarioPiezas();

        // Preparar datos de prueba para usuarios
        List<String> usuarios = Arrays.asList(
            "JuanPerez,1234,comprador,20000.0",
            "AnaGomez,5678,cliente,15000.0",
            "CarlosRuiz,91011,propietario,12000.0"
        );
        Files.write(Paths.get(rutaUsuarios), usuarios);

        // Preparar datos de prueba para piezas
        List<String> piezas = Arrays.asList(
            "La Joven de la Perla,1665,Johannes Vermeer,Países Bajos,true,JuanPerez,Madrid,15000.0",
            "El Grito,1893,Edvard Munch,Noruega,false,AnaGomez,Oslo,17000.0",
            "Guernica,1937,Pablo Picasso,España,true,CarlosRuiz,Barcelona,20000.0"
        );
        Files.write(Paths.get(rutaPiezas), piezas);
    }

    @Test
    void testCargarUsuariosYValidarUsuarios() {
        admin.cargarUsuarios(rutaUsuarios);
        assertTrue(admin.usuariosValidos.contains("juanperez"));
        assertFalse(admin.usuariosValidos.contains("anagomez"));
        assertTrue(admin.usuariosValidos.contains("carlosruiz"));
    }

    @Test
    void testCargarPiezasYAsociar() {
        admin.cargarUsuarios(rutaUsuarios);
        admin.cargarPiezas(rutaPiezas);
        assertTrue(admin.piezasPorComprador.containsKey("juanperez"));
        assertFalse(admin.piezasPorComprador.containsKey("anagomez"));
        assertTrue(admin.piezasPorComprador.get("carlosruiz").contains("Guernica, 20000.0"));
    }

    @Test
    void testEscribirArchivo() throws IOException {
        admin.cargarUsuarios(rutaUsuarios);
        admin.cargarPiezas(rutaPiezas);
        admin.escribirArchivo(rutaSalida);

        // Leer el archivo generado y verificar contenido
        List<String> lines = Files.readAllLines(Paths.get(rutaSalida));
        assertEquals("juanperez, [La Joven de la Perla, 15000.0]", lines.get(0));
        assertEquals("carlosruiz, [Guernica, 20000.0]", lines.get(1));
    }
}
