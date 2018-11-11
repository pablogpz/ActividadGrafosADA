/**
 * Interfaz que define las operaciones fundamentales de cualquier grafo implementado mediante matriz de adyacencia.
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */
public interface Grafo {

    /**
     * Inicializa la estructura soporte del grafo
     */
    void crear();

    /**
     * Inserta un vértice nuevo en el grafo
     *
     * @param vertice Vértice a insertar
     */
    void insertarVertice(int vertice);

    /**
     * Inserta un arco en el grafo
     *
     * @param vInicio Vértice inicial del arco
     * @param vFin    Vértice final del arco
     * @param valor   Valor de la etiqueta del arco, si debe existir
     */
    void insertarArco(int vInicio, int vFin, float valor);

    /**
     * Devuelve el valor del arco formado por dos vértices del grafo.
     *
     * @param vInicio Vértice inicial del arco
     * @param vFin    Vértice final del arco
     * @return el valor del arco formado por ambos vértices
     */
    float obtenerArco(int vInicio, int vFin);

    /**
     * Borra un vértice del grafo. Puede provocar el borrado de un arco si el vértice a borrar tiene un grado mayor que 0
     *
     * @param vertice Vértice a borrar
     */
    void borrarVertice(int vertice);

    /**
     * Borra el arco del grafo representado por los vértices de inicio y fin
     *
     * @param vInicio Vértice inicial del camino a borrar
     * @param vFin    Vértice final del camino a borrar
     */
    void borrarArco(int vInicio, int vFin);

    /**
     * @return Si el grafo contiene algún vértice
     */
    boolean vacio();

    /**
     * @return El conjunto de vértices del grafo
     */
    int[] vertices();

    /**
     * @return Matriz de adyacencia del grafo
     */
    float[][] arcos();

    /**
     * @param vertice Vértice del que devolver sus adyacentes
     * @return Conjunto de vértices adyacentes al dado. Devuelve nulo si su grado es 0
     */
    int[] adyacentes(int vertice);

}