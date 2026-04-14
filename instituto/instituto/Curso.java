package instituto;

import java.util.TreeSet;

/**
 * Representa un curso de un instituto, identificado por un nombre
 * y con una lista de alumnos almacenada en un {@link TreeSet}.
 *
 * @author ProfDiurno
 * @version 1.0
 */
public class Curso {

    private String nombre;
    private TreeSet<Persona> listaAlumnos;

    /**
     * Devuelve el nombre del curso.
     *
     * @return nombre del curso
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Crea un nuevo curso con el nombre indicado e
     * inicializa la lista de alumnos vacía.
     *
     * @param nombre nombre del curso
     */
    public Curso(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new TreeSet<>();
    }

    /**
     * Devuelve una representación en texto del curso,
     * incluyendo un encabezado y el listado de alumnos.
     *
     * @return cadena con la información del curso y sus alumnos
     */
    @Override
    public String toString() {
        String s = "--------------------" + nombre + "-----------------\n";
        s += "NumExp\tNIF\t\tNombre\t\tApellidos\n";
        s += "-------------------------------------------------\n";
        for (Persona listaAlumno : listaAlumnos) {
            s += listaAlumno + "\n";
        }
        return s;
    }

    /**
     * Añade un alumno al curso. La colección interna es un
     * {@link TreeSet}, por lo que no se permitirán duplicados
     * según el criterio de comparación de {@link Persona}.
     *
     * @param p alumno a añadir al curso
     */
    public void aniadirAlumno(Persona p) {
        listaAlumnos.add(p);
    }
}
