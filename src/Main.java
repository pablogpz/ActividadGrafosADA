/**
 * Clase principal que contiene el punto de entrada al programa.
 * Encargada de manejar el flujo de ejecución del programa
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
     * @return Cadena con el recorrido más corto y su longitud
     */
    private static String calcularMinimoCamino(GrafoNDVIndexCad grafoEntrada, String cInicial, String cFinal) {
        // TODO - implement Main.calcularMinimoCamino
        return null;
    }

    public static void main(String[] args) {
        Lector lector = new Lector();                           // Lector del flujo de entrada estándar
        Escritor escritor = new Escritor();                     // Escritor del flujo de salida estándar

        int n;                                                  // Número de ciudades del mapa
        int d;                                                  // Número de carreteras del mapa
        int p;                                                  // Número de preguntas
        String[][] preguntas;                                   // Campos de las preguntas sobre caminos mínimos
        GrafoNDVIndexCad mapaCarreteras;                        // Grafo del mapa de carreteras (vértices -> ciudades)

        // *** LECTURA DE DATOS ***

        n = lector.leerNumero();                                // Lee el número de ciudades del mapa
        mapaCarreteras = new GrafoNDVIndexCad(n);               // Inicializa el mapa con las ciudades iniciales
        for (int i = 0; i < n; i++) {                           // Añade las ciudades al mapa
            mapaCarreteras.añadirVertice(lector.leerLinea());
        }

        d = lector.leerNumero();                                // Lee el número de carreteras del mapa
        String[] datos;                                         // Campos de la línea: 2 ciudades y 1 distancia
        for (int i = 0; i < d; i++) {
            datos = lector.leerLinea().split(" ");        // Divide la línea en sus campos
            // Inserta la ciudad en el mapa de carreteras
            mapaCarreteras.añadirArco(datos[0], datos[1], Float.parseFloat(datos[2]));
        }

        // *** PROBLEMA 1 ***

        p = lector.leerNumero();                                // Lee el número de preguntas acerca de caminos mínimos
        preguntas = new String[p][];                            // Inicializa la matriz de preguntas
        // Datos de la línea: 2 ciudades
        for (int i = 0; i < p; i++) {
            preguntas[i] = lector.leerLinea().split(" "); // Divide la línea en sus campos
            // Calcula el camíno mínimo y lo escribe
            escritor.escribirLinea(calcularMinimoCamino(mapaCarreteras, preguntas[i][0], preguntas[i][1]));
        }

        // *** PROBLEMA 2 ***

        // Convierte el mapa de carreteras tal que todas las ciudades estén conectadas y el coste de repararlas sea mínimo
        mapaCarreteras = calcularExpansionMinima(mapaCarreteras);
        escritor.escribirLinea("");                             // Nueva línea
        // TODO Escribir el coste total de rehabilitación de carreteras

        // Calcula los caminos mínimos a partir del nuevo mapa de carreteras
        for (int i = 0; i < p; i++) {
            // Calcula el camíno mínimo y lo escribe
            escritor.escribirLinea(calcularMinimoCamino(mapaCarreteras, preguntas[i][0], preguntas[i][1]));
        }
    }

}