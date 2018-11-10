/**
 * Clase principal que contiene el punto de entrada al programa.
 * Encargada de manejar el flujo de ejecución
 *
 * @author Juan Pablo García Plaza Pérez - Jose Ángel Concha Carrasco
 */
public class Main {

    /**
     * TODO Documentar el algoritmo de cálculo de árboles de expansión mínimos
     *
     * @param grafoEntrada Grafo del que calcular su árbol de expasión mínimo
     * @return Árbol de expasión mínimo
     */
    private static GrafoNDVIndexCad calcularExpansionMinima(GrafoNDVIndexCad grafoEntrada) {
        // TODO - implement Main.calcularExpansionMinima
        return null;
    }

    /**
     * TODO Documentar el algoritmo de cálculo de caminos mínimos
     *
     * @param grafoEntrada Grafo que represente el mapa de carreteras
     * @param cInicial     Nombre de la ciudad de partida
     * @param cFinal       Nombre de la ciudad de destino
     */
    private static void calcularMinimoCamino(GrafoNDVIndexCad grafoEntrada, String cInicial, String cFinal) {
        // TODO - implement Main.calcularMinimoCamino
    }

    public static void main(String[] args) {
        Lector lector = new Lector();                           // Lector del flujo de entrada estándar
        Escritor escritor = new Escritor();                     // Escritor del flujo de salida estándar

        int n;                                                  // Número de ciudades del mapa
        int d;                                                  // Número de carreteras del mapa
        int p;                                                  // Número de preguntas
        GrafoNDVIndexCad mapaCarreteras;                        // Grafo del mapa de carreteras (vértices -> ciudades)

        n = lector.leerNumero();                                // Lee el número de ciudades del mapa
        mapaCarreteras = new GrafoNDVIndexCad(n);               // Inicializa el mapa con las ciudades iniciales
        for (int i = 0; i < n; i++) {                           // Añade las ciudades al mapa
            mapaCarreteras.añadirCiudad(lector.leerLinea());
        }
    }

}