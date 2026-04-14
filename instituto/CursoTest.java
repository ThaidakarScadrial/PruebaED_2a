package instituto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CursoTest {

    @Test
    public void testAniadirAlumnoUnaVez() {
        Curso c = new Curso("DAM");
        Persona p = new Persona(12345678, "Teo Alvarez", 'F', 1, 1, 2000);

        c.aniadirAlumno(p);

        String salida = c.toString();
        assertTrue(salida.contains("Teo"), "El curso debería contener a Teo");
        assertTrue(salida.contains("12345678"), "El NIF debería aparecer en el listado");
    }

    @Test
    public void testAniadirAlumnoDuplicadoNoDuplicaEnTreeSet() {
        Curso c = new Curso("DAM");
        Persona p1 = new Persona(12345678, "Teo Alvarez", 'F', 1, 1, 2000);
        Persona p2 = new Persona(12345678, "Teo Alvarez", 'F', 1, 1, 2000); // mismo NIF

        c.aniadirAlumno(p1);
        c.aniadirAlumno(p2);

        String salida = c.toString();
        int primera = salida.indexOf("12345678");
        int segunda = salida.indexOf("12345678", primera + 1);

        assertEquals(-1, segunda, "No debería haber dos alumnos con el mismo NIF en el TreeSet");
    }
}
