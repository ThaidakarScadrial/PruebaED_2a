package instituto;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void testGetEdad() {
        // Persona nacida hace 20 años exactos
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = hoy.minusYears(20);

        Persona p = new Persona();
        p.setNacimiento(nacimiento);

        assertEquals(20, p.getEdad(), "La edad debería ser 20 años");
    }

    @Test
    public void testEqualsMismoNif() {
        Persona p1 = new Persona(12345678, "Ana Perez", 'F', 1, 1, 2000);
        Persona p2 = new Persona(12345678, "Ana Perez", 'F', 1, 1, 2000);

        assertTrue(p1.equals(p2), "Dos personas con el mismo NIF deben ser iguales");
        assertTrue(p1.equals((Object)p2), "equals(Object) también debe devolver true");
    }

    @Test
    public void testEqualsDistintoNif() {
        Persona p1 = new Persona(12345678, "Ana Perez", 'F', 1, 1, 2000);
        Persona p2 = new Persona(87654321, "Ana Perez", 'F', 1, 1, 2000);

        assertFalse(p1.equals(p2), "Personas con distinto NIF no deben ser iguales");
    }

    @Test
    public void testCompareToOrdenPorNif() {
        Persona p1 = new Persona(12345678, "Ana Perez", 'F', 1, 1, 2000);
        Persona p2 = new Persona(22345678, "Teo Alvarez", 'M', 1, 1, 2000);

        assertTrue(p1.compareTo(p2) < 0, "El NIF menor debe ir antes en el orden");
        assertTrue(p2.compareTo(p1) > 0, "El NIF mayor debe ir después en el orden");
    }
}
