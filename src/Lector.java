import java.io.IOException;
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
     * @return Número leído del flujo de entrada estándar
     */
    public int leerNumero() {
        return Integer.parseInt(leerLinea());
    }

    /**
     * @return Línea leída del flujo de entrada estándar
     */
    public String leerLinea() {
        int sigByte = -1;
        StringBuilder sb = new StringBuilder();

        do {
            try {
                sigByte = entradaEstandar.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append((char) sigByte);
        } while (sigByte != '\n');

        return sb.toString().trim();
    }

}