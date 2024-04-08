/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trabajoenparejasgradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {

    @Test
    void agregarPlatoAlMenu() {
        App app = new App();
        app.agregarPlatoAlMenu("Pizza", 10.99);
        assertTrue(app.getMenu().containsKey("Pizza"));
        assertEquals(10.99, app.getMenu().get("Pizza"));
    }

    @Test
    void eliminarPlatoDelMenu() {
        App app = new App();
        app.agregarPlatoAlMenu("Ensalada", 7.99);
        app.eliminarPlatoDelMenu("Ensalada");
        assertFalse(app.getMenu().containsKey("Ensalada"));
    }

    @Test
    void listarMenu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        App app = new App();
        app.agregarPlatoAlMenu("Hamburguesa", 8.50);
        app.agregarPlatoAlMenu("Refresco", 2.50);
        app.listarMenu();
        assertTrue(outContent.toString().contains("Hamburguesa"));
        assertTrue(outContent.toString().contains("Refresco"));
    }

    @Test
    void crearPedido() {
        App app = new App();
        int idPedido = app.crearPedido();
        assertTrue(app.getPedidos().containsKey(idPedido));
    }

    @Test
    void agregarPlatoAlPedido() {
        App app = new App();
        app.agregarPlatoAlMenu("Sushi", 15.99);
        int idPedido = app.crearPedido();
        app.agregarPlatoAlPedido(idPedido, "Sushi");
        assertTrue(app.getPedidos().get(idPedido).containsKey("Sushi"));
    }

    @Test
    void calcularTotalPedido() {
        App app = new App();
        app.agregarPlatoAlMenu("Pasta", 12.75);
        app.agregarPlatoAlMenu("Pizza", 10.25);
        int idPedido = app.crearPedido();
        app.agregarPlatoAlPedido(idPedido, "Pasta");
        app.agregarPlatoAlPedido(idPedido, "Pizza");
        assertEquals(23, app.calcularTotalPedido(idPedido));
    }

    @Test
    void mostrarPedido() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        App app = new App();
        app.agregarPlatoAlMenu("Tacos", 9.25);
        int idPedido = app.crearPedido();
        app.agregarPlatoAlPedido(idPedido, "Tacos");
        app.mostrarPedido(idPedido);
        assertTrue(outputStreamCaptor.toString().contains("Tacos"));
        assertTrue(outputStreamCaptor.toString().contains("9.25"));
    }
}
