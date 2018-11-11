import java.util.ArrayList;

/**
 * Clase principal que contiene el punto de entrada al programa.
 * Encargada de manejar el flujo de ejecución del programa
 *
 * @author Juan Pablo García Plaza Pérez - Jose Ángel Concha Carrasco
 */
public class Main {

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

    /**
     * TODO Documentar el algoritmo de cálculo de árboles de expansión mínimos
     *
     * @param grafoEntrada Grafo del que calcular su árbol de expasión mínimo
     * @param grafoRes     Árbol de expansión mínimo del grafo de entrada
     * @return Suma de los valores de las etiquetas del árbol de expasión mínimo
     */
    private static float calcularExpansionMinima(GrafoNDVIndexCad grafoEntrada,
                                                 GrafoNDVIndexCad grafoRes) {
        float sumaEtiquetas = 0;                                // Suma total del valor de las etiquetas
        ArrayList<String> cjtoVertices = new ArrayList<>();     // Cjto de vértices del grafo resultado
        String[] verticesEntrada = grafoEntrada.verticesCadena();// Cjo de vértices del grafo de entrada
        String[] adyacentes;                                    //Adyacentes a cada vértice seleccionado
        String u;                                               // Vértice actual
        String v;                                               // Vértice adyacente

        for (int i = 0; cjtoVertices.size() < verticesEntrada.length; i++) {
            cjtoVertices.add(verticesEntrada[i]);               // Añade el vértice actual a los visitados
            u = verticesEntrada[i];
            adyacentes = grafoEntrada.adyacentes(cjtoVertices.get(i));// Obtiene sus adyacentes

            String minimo = adyacentes[0];                      // Vértice final que hace el arco mínimo
            for (int j = 1; j < adyacentes.length; j++) {       // Busca el camino mínimo con el vértice actual
                v = adyacentes[j];

                if (grafoEntrada.obtenerValorArco(u, v) > grafoEntrada.obtenerValorArco(u, minimo)) {
                    minimo = v;                                 // Actualiza el vértice mínimo
                }
            }

            sumaEtiquetas += grafoEntrada.obtenerValorArco(u, minimo);
        }

        return sumaEtiquetas;
    }

    public static void main(String[] args) {
        Lector lector = new Lector();                           // Lector del flujo de entrada estándar
        Escritor escritor = new Escritor();                     // Escritor del flujo de salida estándar

        int n;                                                  // Número de ciudades del mapa
        int d;                                                  // Número de carreteras del mapa
        int p;                                                  // Número de preguntas
        String[][] preguntas;                                   // Campos de las preguntas sobre caminos mínimos
        GrafoNDVIndexCad mapaCarreteras;                        // Grafo del mapa de carreteras (vértices -> ciudades)
        GrafoNDVIndexCad minimasCarreteras;                     // Grafo con las carreteras mínimas para conectar toda ciudad

        // *** LECTURA DE DATOS ***

        n = lector.leerNumero();                                // Lee el número de ciudades del mapa
        mapaCarreteras = new GrafoNDVIndexCad(n);               // Inicializa el mapa con las ciudades iniciales
        for (int i = 0; i < n; i++) {                           // Añade las ciudades al mapa
            mapaCarreteras.insertarVertice(lector.leerLinea());
        }

        d = lector.leerNumero();                                // Lee el número de carreteras del mapa
        String[] datos;                                         // Campos de la línea: 2 ciudades y 1 distancia
        for (int i = 0; i < d; i++) {
            datos = lector.leerLinea().split(" ");        // Divide la línea en sus campos
            // Inserta la ciudad en el mapa de carreteras
            mapaCarreteras.insertarArco(datos[0], datos[1], Float.parseFloat(datos[2]));
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
        escritor.escribirLinea("");                             // Nueva línea

        // *** PROBLEMA 2 ***

        // Convierte el mapa de carreteras tal que todas las ciudades estén conectadas y el coste de repararlas sea mínimo
        minimasCarreteras = new GrafoNDVIndexCad(mapaCarreteras.getOrden());
        // Escribe el coste de reparar las mínimas carreteras
        escritor.escribirLinea(String.valueOf(calcularExpansionMinima(mapaCarreteras, minimasCarreteras)));
        // TODO Escribir el coste total de rehabilitación de carreteras

        // Calcula los caminos mínimos a partir del nuevo mapa de carreteras
        for (int i = 0; i < p; i++) {
            // Calcula el camíno mínimo y lo escribe
            escritor.escribirLinea(calcularMinimoCamino(minimasCarreteras, preguntas[i][0], preguntas[i][1]));
        }
    }

}