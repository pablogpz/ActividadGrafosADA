import java.io.InputStream;

/**
 * Clase que implementa una serie de operaciones de lectura del flujo estándar
 *
 * @author Juan Pablo García Plaza Pérez - Jose Ángel Concha Carrasco
 */
public class Lector {

    /**
     * Flujo de entrada estándar
     */
    private InputStream entradaEstandar;

    /**
     * Constructor por defecto de la clase. Inicializa el flujo de entrada estándar
     */
    public Lector() {
        entradaEstandar = System.in;
    }

    /**
     * Lee un número de la entrada estándar
     */
    public int leerNumero() {
        // TODO - implement Lector.leerNumero
        return 0;
    }

    /**
     * Lee una línea del flujo de entrada estándar
     */
    public String leerLinea() {
        // TODO - implement Lector.leerLinea
        return null;
    }

}