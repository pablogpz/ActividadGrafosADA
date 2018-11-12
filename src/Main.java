import java.util.ArrayList;

/**
 * Clase principal que contiene el punto de entrada al programa.
 * Encargada de manejar el flujo de ejecución del programa
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */
public class Main {

    private static final int P_NULO = -1;                           // Valor nulo de la matriz P de actualiación

    /**
     * Calcula la matriz de cierre transitivo del grafo de entrada aplicando el algoritmo de Floyd
     *
     * @param grafoEntrada Grafo de entrada
     * @param P            Matriz de actualizaciones sobre la matriz de cierre transitivo
     * @return Matriz de cierre transitivo
     */
    private static float[][] calcularCierreTransitivo(GrafoNDVIndexCad grafoEntrada, int[][] P) {
        int orden = grafoEntrada.getOrden();                        // Orden de la matriz de adyacencia del grafo
        float[][] mCierreT = new float[orden][orden];               // Matriz de cierre transitivo
        float caminoNuevo;                                          // Longitud del camino formado por [i,k] y [k,j]

        // Copia la matriz de adyacencia del grafo en 'mCierreT'
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                mCierreT[i][j] = grafoEntrada.getMatrizAdy()[i][j];
            }
        }

        for (int k = 0; k < orden; k++) {
            for (int i = 0; i < orden; i++) {
                for (int j = 0; j < orden; j++) {
                    caminoNuevo = mCierreT[i][k] + mCierreT[k][j];
                    if (caminoNuevo < mCierreT[i][j]) {             // Actualiza el camino si el nuevo es menor
                        mCierreT[i][j] = caminoNuevo;
                        P[i][j] = k;                                // Actualiza la matriz P
                    }
                }
            }
        }

        return mCierreT;
    }

    /**
     * Calcula la secuencia de vértioes que conforman el camíno mínimo entre dos vértices
     * aplicando el algoritmo de recuperación de caminos de Floyd
     *
     * @param mCierreT Matriz de cierre transitivo que ocntiene los caminos mínimos
     * @param P        Matriz de actualizaciones de la matriz de cierre transitivo
     * @param vInicial Vértice de partida
     * @param vFinal   Vértice final
     * @param g        Grafo del que proviene la matriz de cierre transitivo
     */
    private static void calcularMinimoCamino(float[][] mCierreT, int[][] P, String vInicial, String vFinal,
                                             GrafoNDVIndexCad g) {
        int k = P[g.indiceEquivalente(vInicial)][g.indiceEquivalente(vFinal)];

        if (k != P_NULO) {
            calcularMinimoCamino(mCierreT, P, vInicial, g.cadenaEquivalente(k), g);
            System.out.print(g.cadenaEquivalente(k) + " ");
            calcularMinimoCamino(mCierreT, P, g.cadenaEquivalente(k), vFinal, g);
        }
    }

    /**
     * Calcula el árbol de expansión mínimo del grafo de entrada mediante el algoritmo de Prim
     *
     * @param grafoEntrada Grafo del que calcular su árbol de expasión mínimo
     * @param grafoRes     Árbol de expansión mínimo del grafo de entrada
     * @return Suma de los valores de las etiquetas del árbol de expasión mínimo
     */
    private static float calcularExpansionMinima(GrafoNDVIndexCad grafoEntrada,
                                                 GrafoNDVIndexCad grafoRes) {
        ArrayList<String> cjtoVertices = new ArrayList<>();         // Cjto de vértices del grafo resultado
        String[] verticesEntrada = grafoEntrada.verticesCadena();   // Cjto de vértices del grafo de entrada
        String[] adyacentes;                                        //Adyacentes a cada vértice seleccionado
        String uMinimo = null;                                      // Vértice inicial que hizo el arco mínimo
        String vMinimo = null;                                      // Vértice final que hizo el arco mínimo
        float caminoMinimo;                                         // Camino mínimo en cada exploración
        float sumaEtiquetas = 0;                                    // Suma total del valor de las etiquetas

        cjtoVertices.add(verticesEntrada[0]);                       // Empieza por el primer vértice
        while (cjtoVertices.size() < verticesEntrada.length) {
            caminoMinimo = MatrizAdyacencia.ELEMENTO_VACIO;         // Reinicializa al valor nulo el camino mínimo

            for (String vertice : cjtoVertices) {                   // Para cada vértice del 'cjtoVertices', explora sus adyacentes
                adyacentes = grafoEntrada.adyacentes(vertice);      // Obtiene los adyacentes de cada vértice

                for (String adyacente : adyacentes) {               // Para cada adyacente del vértice actual
                    if (!cjtoVertices.contains(adyacente)) {        // Comprueba que el adyacente no esté en 'cjtoVertices'
                        // Actualiza los vértices y camino mínimo si procede
                        if (grafoEntrada.obtenerValorArco(vertice, adyacente) < caminoMinimo) {
                            uMinimo = vertice;
                            vMinimo = adyacente;
                            caminoMinimo = grafoEntrada.obtenerValorArco(uMinimo, vMinimo);
                        }
                    }
                }
            }

            // Añade el camino al grafo resultado
            grafoRes.insertarArco(uMinimo, vMinimo, caminoMinimo);
            cjtoVertices.add(vMinimo);                              // Añade el vértice elegido a los visitados
            sumaEtiquetas += caminoMinimo;                          // Actualiza el acumulador
        }

        return sumaEtiquetas;
    }

    /**
     * Rellena una matriz con el elemento indicado
     *
     * @param matriz Matriz de enteros a inicializar
     * @param valor  Elemento con el que inicializar las celdas de la matriz
     */
    private static void inicializarMatri(int[][] matriz, int valor) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = valor;
            }
        }
    }

    public static void main(String[] args) {
        Lector lector = new Lector();                               // Lector del flujo de entrada estándar
        Escritor escritor = new Escritor();                         // Escritor del flujo de salida estándar

        int n;                                                      // Número de ciudades del mapa
        int d;                                                      // Número de carreteras del mapa
        int p;                                                      // Número de preguntas
        int[][] P;                                                  // Matriz de actualizaciones sobre la mCierreT
        float[][] mCierreT;                                         // Matriz de cierre transitivo
        String[][] preguntas;                                       // Campos de las preguntas sobre caminos mínimos
        GrafoNDVIndexCad mapaCarreteras;                            // Grafo del mapa de carreteras (vértices -> ciudades)
        GrafoNDVIndexCad minimasCarreteras;                         // Grafo con las carreteras mínimas para conectar toda ciudad

        // *** LECTURA DE DATOS ***

        n = lector.leerNumero();                                    // Lee el número de ciudades del mapa
        mapaCarreteras = new GrafoNDVIndexCad(n);                   // Inicializa el mapa con las ciudades iniciales
        for (int i = 0; i < n; i++) {                               // Añade las ciudades al mapa
            mapaCarreteras.insertarVertice(lector.leerLinea());
        }

        d = lector.leerNumero();                                    // Lee el número de carreteras del mapa
        String[] datos;                                             // Campos de la línea: 2 ciudades y 1 distancia
        for (int i = 0; i < d; i++) {
            datos = lector.leerLinea().split(" ");            // Divide la línea en sus campos
            // Inserta la ciudad en el mapa de carreteras
            mapaCarreteras.insertarArco(datos[0], datos[1], Float.parseFloat(datos[2]));
        }


        // *** PROBLEMA 1 ***


        p = lector.leerNumero();                                    // Lee el número de preguntas acerca de caminos mínimos
        preguntas = new String[p][];                                // Inicializa la matriz de preguntas
        // Inicializa la matriz P de actualizaciones con un valor nulo
        P = new int[mapaCarreteras.getOrden()][mapaCarreteras.getOrden()];
        inicializarMatri(P, Main.P_NULO);

        mCierreT = calcularCierreTransitivo(mapaCarreteras, P);     // Calcula la matriz de cierre transitivo del mapa
        // Datos de la línea: 2 ciudades
        for (int i = 0; i < p; i++) {
            preguntas[i] = lector.leerLinea().split(" ");     // Divide la línea en sus campos
            // Calcula el camíno mínimo y lo escribe
            escritor.escribirCadena(preguntas[i][0] + " ");         // Escribe la ciudad de partida
            calcularMinimoCamino(mCierreT, P, preguntas[i][0], preguntas[i][1], mapaCarreteras);
            escritor.escribirCadena(preguntas[i][1] + " ");         // Escribe la ciudad destino
            // Escribe la longitud del camino
            escritor.escribirLinea(String.valueOf(mCierreT[mapaCarreteras.indiceEquivalente(preguntas[i][0])]
                    [mapaCarreteras.indiceEquivalente(preguntas[i][1])]));
        }
        escritor.escribirCadena("\n");                              // Nueva línea


        // *** PROBLEMA 2 ***


        // Convierte el mapa de carreteras tal que todas las ciudades estén conectadas y el coste de repararlas sea mínimo
        minimasCarreteras = new GrafoNDVIndexCad(mapaCarreteras.getOrden());
        // Copia el diccionario de nombres de ciudades en el nuevo grafo
        minimasCarreteras.setDiccionarioCadenas(mapaCarreteras.getDiccionarioCadenas());

        // Escribe el coste de reparar las mínimas carreteras
        escritor.escribirLinea(String.valueOf(calcularExpansionMinima(mapaCarreteras, minimasCarreteras)));

        // Reinicializa la matriz P para el nuevo mapa
        inicializarMatri(P, Main.P_NULO);

        mCierreT = calcularCierreTransitivo(minimasCarreteras, P);  // Calcula la matriz de cierre transitivo del nuevo mapa
        // Calcula los caminos mínimos a partir del nuevo mapa de carreteras
        for (int i = 0; i < p; i++) {
            escritor.escribirCadena(preguntas[i][0] + " ");         // Escribe la ciudad de partida
            // Calcula el camíno mínimo y lo escribe
            calcularMinimoCamino(mCierreT, P, preguntas[i][0], preguntas[i][1], minimasCarreteras);
            escritor.escribirCadena(preguntas[i][1] + " ");         // Escribe la ciudad destino
            // Escribe la longitud del camino
            escritor.escribirLinea(String.valueOf(mCierreT[minimasCarreteras.indiceEquivalente(preguntas[i][0])]
                    [minimasCarreteras.indiceEquivalente(preguntas[i][1])]));
        }
    }

}