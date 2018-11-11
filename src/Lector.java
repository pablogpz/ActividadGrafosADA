import java.io.IOException;
import java.io.InputStream;

/**
 * Clase que implementa una serie de operaciones de lectura del flujo estándar
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
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
     * @return Número leído del flujo de entrada estándar
     */
    public int leerNumero() {
        return Integer.parseInt(leerLinea());
    }

    /**
     * @return Línea leída del flujo de entrada estándar
     */
    public String leerLinea() {
        int sigByte = -1;                                   // Cada carácter de una línea del flujo
        StringBuilder sb = new StringBuilder();             // Para generar la cadena de línea

        do {                                                // Lee una línea (Hasta que encuentra el caracter '\n')
            try {
                sigByte = entradaEstandar.read();
            } catch (IOException e) {                       // Manejo de excepción de I/O
                e.printStackTrace();
            }
            sb.append((char) sigByte);
        } while (sigByte != '\n');

        return sb.toString().trim();
    }

}