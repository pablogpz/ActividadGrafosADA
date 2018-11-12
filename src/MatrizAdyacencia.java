/**
 * Clase que modela una matriz cuadrada de ocupación variable entre 1 y 20 nodos (ambos inclusive).
 * Representa la matriz adyacencia tanto de grafos valuados como no valuados.
 * Es de orden igual al número de vértices del grafo <p>.
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */

public class MatrizAdyacencia {

    private float[][] matrizAdy;                                         // Matriz de adayacencia de números reales.
    private int orden;                                                   // Orden de la matriz: Número de nodos que puede alojar.

    protected static final float ELEMENTO_VACIO = Integer.MAX_VALUE;     // Indicador de que no hay camino.
    protected static final float ELEMENTO_NULO = 0;                      // Indicador de que no es posible trazar camino sobre sí mismo.

    /**
     * Constructor parametrizado de la clase. Inicializa la matriz con un orden dado.
     *
     * @param orden Orden de la matriz a inicializar
     */
    public MatrizAdyacencia(int orden) {
        this.orden = orden;                                              // Guarda el orden
        matrizAdy = new float[orden][orden];                             // Reserva de espacio para la matriz de orden 'orden'

        for (int i = 0; i < orden; i++) {                                // Asignamos a todas las celdas el valor de ELEMENTO_VACIO,
            for (int j = 0; j < orden; j++) {                            // Salvo a la diagonal principal de la matriz
                if (i == j)
                    matrizAdy[i][j] = ELEMENTO_NULO;
                else
                    matrizAdy[i][j] = ELEMENTO_VACIO;
            }
        }
    }

    /**
     * Cambia el valor de una celda de la matriz. Es una operacióin destructiva,
     * sobreescribe el antiguo valor
     *
     * @param fila    Fila
     * @param columna Columna
     * @param valor   Valor a insertar
     */
    protected void modificarCelda(int fila, int columna, float valor) {
        matrizAdy[fila][columna] = valor;
    }

    /**
     * @param fila    Fila de la matriz a seleccionar
     * @param columna Columna de la matriz a seleccionar
     * @return Valor de la celda pedida
     */
    protected float obtenerValorCelda(int fila, int columna) {
        return matrizAdy[fila][columna];
    }

    /**
     * Inicializa la fila y columna equivalente al índice doble [indice][indice],
     * incrementando el orden de la matriz en una unidad
     *
     * @param indice indice que indique la fila y columna a inicializar
     */
    protected void insertarIndice(int indice) {
    }

    /**
     * Rellena con el valor nulo un índice conjunto de fila y columna,
     * decrementando en 1 el orden de la matriz
     *
     * @param indice Indice a borrar
     */
    protected void borrarIndice(int indice) {
    }

    /**
     * Modifica el orden de la matriz. Un incremento positivo incrementa el orden y
     * un incremento negativo lo decrementa
     *
     * @param variacion Valor en el que variar el orden de la matriz
     */
    private void modificarOrden(int variacion) {
        this.orden += variacion;
    }

    /**
     * @return Devuelve el orden de la matriz
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @return La matriz de adyacencia
     */
    public float[][] getMatrizAdy() {
        return matrizAdy;
    }

}