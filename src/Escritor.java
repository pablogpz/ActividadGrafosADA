import java.io.PrintStream;

/**
 * Clase que implementa una serie de operaciones de escritura en el flujo estándar
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */
public class Escritor {

    /**
     * Flujo de salida estándar
     */
    private PrintStream salidaEstandar;

    /**
     * Constructor por defecto de la clase. Inicializa la salida estándar
     */
    public Escritor() {
        salidaEstandar = System.out;
    }

    /**
     * Escribe una línea al flujo de salida estándar
     *
     * @param linea Línea a escribir
     */
    public void escribirLinea(String linea) {
        salidaEstandar.println(linea);
    }

}