package instituto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Representa a una persona del instituto, identificada por un NIF,
 * nombre, género y fecha de nacimiento.
 *
 * Implementa {@link Comparable} para poder ordenarse por NIF.
 *
 * @author ProfDiurno
 * @version 1.0
 */
public class Persona implements Comparable<Persona> {

    private Nif nif;
    private String nombre;
    private char genero;
    private LocalDate nacimiento;

    /**
     * Crea una persona por defecto con NIF vacío, nombre vacío,
     * género sin especificar y fecha de nacimiento 01/01/1990.
     */
    public Persona() {
        nif = new Nif();
        nombre = "";
        genero = ' ';
        nacimiento = LocalDate.of(1990, 1, 1);
    }

    /**
     * Crea una persona a partir de un número de NIF.
     *
     * @param nif número de NIF de la persona
     */
    public Persona(int nif) {
        this();
        this.nif = new Nif(nif);
    }

    /**
     * Crea una persona con todos sus datos.
     *
     * @param nif número de NIF
     * @param nombre nombre completo
     * @param genero género de la persona
     * @param dia día de nacimiento
     * @param mes mes de nacimiento
     * @param ano año de nacimiento
     */
    public Persona(int nif, String nombre, char genero,
            int dia, int mes, int ano) {
        this.nif = new Nif(nif);
        this.nombre = nombre;
        this.genero = genero;
        this.nacimiento = LocalDate.of(ano, mes, dia);
    }

    /**
     * Devuelve el NIF de la persona.
     *
     * @return NIF de la persona
     */
    public Nif getNif() {
        return nif;
    }

    /**
     * Establece el NIF de la persona.
     *
     * @param nif nuevo NIF
     */
    public void setNif(Nif nif) {
        this.nif = nif;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el género de la persona.
     *
     * @return género
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     *
     * @param genero nuevo género
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Devuelve la fecha de nacimiento de la persona.
     *
     * @return fecha de nacimiento
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param nacimiento nueva fecha de nacimiento
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Calcula la edad de la persona en años completos
     * a partir de su fecha de nacimiento y la fecha actual.
     *
     * @return edad en años
     */
    public int getEdad() {
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    /**
     * Devuelve una representación en texto de la persona,
     * incluyendo NIF, nombre y edad.
     *
     * @return cadena con la información formateada
     */
    @Override
    public String toString() {
        if (nombre.split(" ").length > 1) {
            return nif + "\t" + nombre.split(" ")[0]
                    + '\t' + nombre.split(" ")[1] + "\t\t" + getEdad();
        } else {
            return nif + "\t" + nombre + "\t\t\t" + getEdad();
        }
    }

    /**
     * Compara esta persona con otra por NIF.
     *
     * @param a persona con la que se compara
     * @return {@code true} si tienen el mismo NIF, {@code false} en caso contrario
     */
    public boolean equals(Persona a) {
        if (a == null) {
            return false;
        }
        return a.nif.toString().equals(this.nif.toString());
    }

    /**
     * Compara esta persona con otro objeto para determinar si son iguales.
     * Dos personas son iguales si tienen el mismo NIF.
     *
     * @param obj objeto con el que se compara
     * @return {@code true} si ambas personas son iguales, {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;

        return Objects.equals(this.nif, other.nif);
    }

    /**
     * Compara esta persona con otra para establecer un orden natural.
     * El criterio de orden es el NIF en formato texto.
     *
     * @param o persona con la que se compara
     * @return valor negativo, cero o positivo según el orden del NIF
     */
    @Override
    public int compareTo(Persona o) {
        return this.nif.toString().compareTo(o.nif.toString());
    }

}
