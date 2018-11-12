import java.util.ArrayList;

/**
 * Clase que modela un Grafo No Dirigido Valuado con indexado de vértices por enteros.
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */
public class GrafoNDV extends MatrizAdyacencia implements Grafo {

    /**
     * Constructor parametrizado de la clase. Instancia un grafo no dirigido valuado
     *
     * @param nVerticesInic Número de vértices iniciales del grafo
     */
    public GrafoNDV(int nVerticesInic) {
        super(nVerticesInic);
        crear();
    }

    @Override
    public void crear() {
    }

    @Override
    public void insertarVertice(int vertice) {
        insertarIndice(vertice);
    }

    /**
     * Método que inserta un arco entre dos vértices.
     *
     * @param vInicio Vértice inicial del arco
     * @param vFin    Vértice final del arco
     * @param valor   Valor de la etiqueta del arco, si debe existir
     */
    @Override
    public void insertarArco(int vInicio, int vFin, float valor) {
        modificarCelda(vInicio, vFin, valor);
        modificarCelda(vFin, vInicio, valor);                           // Se insertan de forma simétrica
    }

    /**
     * Devuelve el valor del arco formado por ambos vértices.
     *
     * @param vInicio Vértice inicial del arco
     * @param vFin    Vértice final del arco
     * @return el valor del arco
     */
    @Override
    public float obtenerArco(int vInicio, int vFin) {
        return obtenerValorCelda(vInicio, vFin);
    }

    /**
     * Método que elimina un vértice indicado por parámetro
     *
     * @param vertice Vértice a borrar
     */
    @Override
    public void borrarVertice(int vertice) {
        borrarIndice(vertice);
    }

    @Override
    public void borrarArco(int vInicio, int vFin) {
        modificarCelda(vInicio, vFin, MatrizAdyacencia.ELEMENTO_VACIO);
        modificarCelda(vFin, vInicio, MatrizAdyacencia.ELEMENTO_VACIO); // Se elimina de forma simétrica
    }

    /**
     * Método que indica si el grafo es un grafo vacío.
     *
     * @return true si el grafo es un grafo vacío.
     */
    @Override
    public boolean vacio() {
        return getOrden() == 0;
    }

    /**
     * Método que devuelve los vértices que componen el grafo.
     *
     * @return un vector de enteros con los índices de cada vértice.
     */
    @Override
    public int[] vertices() {
        int[] acumulados = new int[getOrden()];                         // Vector de vertices (orden) de la matriz de adyacencia
        for (int i = 0; i < getOrden(); i++) {                          // Inicialización del los vértices con su valor numérico
            acumulados[i] = i;
        }

        return acumulados;
    }

    /**
     * Método que devuelve los arcos que componen el grafo.
     *
     * @return matriz de float con los valores de cada arco.
     */
    @Override
    public float[][] arcos() {                                          // Los arcos son el conjunto de valores de la matriz de adyacencia
        return getMatrizAdy();
    }

    /**
     * Método que devuelve los vértices adyacentes del vértice pasado por parámetro.
     *
     * @param vertice Vértice del que devolver sus adyacentes
     * @return vector de enteros con los índices de cada vértice adyacente al dado.
     */
    @Override
    public int[] adyacentes(int vertice) {
        ArrayList<Integer> vAdyacentes = new ArrayList<>();             // Colección auxiliar para calcular el nº de ady

        for (int i = 0; i < getOrden(); i++) {                          // Comprueba si [i] es adyacente
            if (obtenerValorCelda(vertice, i) > 0 &&                    // Vertices adyacentes
                    obtenerValorCelda(vertice, i) < MatrizAdyacencia.ELEMENTO_VACIO) {
                vAdyacentes.add(i);
            }
        }

        int[] vertices = new int[vAdyacentes.size()];                   // Vector de vertices adyacentes final

        for (int i = 0; i < vAdyacentes.size(); i++) {                  // Paso de la estructura auxiliar a la final
            vertices[i] = vAdyacentes.get(i);
        }

        return vertices;
    }

}