package instituto;

/**
 * Representa un NIF español compuesto por un número y una letra
 * calculada a partir de dicho número.
 *
 * @author ProfDiurno
 * @version 1.0
 */
public class Nif {

    private int numero;
    private char letra;

    /**
     * Conjunto de letras válidas para el cálculo del NIF.
     */
    private static final char[] LETRAS
            = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                'C', 'K', 'E'};

    /**
     * Calcula la letra correspondiente al número de NIF indicado.
     *
     * @param numero número del NIF
     * @return letra asociada al número
     */
    private static char calcularLetra(int numero) {
        return LETRAS[numero % 23];
    }

    /**
     * Crea un NIF vacío con número 0 y sin letra.
     */
    protected Nif() {
        this.numero = 0;
        this.letra = ' ';
    }

    /**
     * Crea un NIF a partir de un número, calculando automáticamente
     * la letra correspondiente.
     *
     * @param numero número del NIF
     */
    protected Nif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }

    /**
     * Devuelve una representación en texto del NIF en formato
     * {@code numero-letra}.
     *
     * @return cadena con el NIF formateado
     */
    @Override
    public String toString() {
        return numero + "-" + letra;
    }

    /**
     * Modifica el número del NIF y recalcula la letra asociada.
     *
     * @param numero nuevo número de NIF
     */
    protected void setNif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }

    /**
     * Compara este NIF con otro objeto para determinar si son iguales.
     * Dos NIF son iguales si tienen el mismo número y la misma letra.
     *
     * @param obj objeto con el que se compara
     * @return {@code true} si ambos NIF son iguales, {@code false} en caso contrario
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
        final Nif other = (Nif) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.letra == other.letra;
    }
}
