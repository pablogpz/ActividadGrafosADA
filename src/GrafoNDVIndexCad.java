import java.util.ArrayList;

/**
 * Clase que modela un grafo no dirigido valuado (con etiquetas positivas y que toman valores reales no negativos)
 * con indexación de cadenas en lugar de indexacion de enteros.
 *
 * @author Juan Pablo García Plaza Pérez - José Ángel Concha Carrasco
 */
public class GrafoNDVIndexCad extends GrafoNDV {

    private ArrayList<String> diccionarioCadenas;       // Colección de cadenas. Permite asociar un índice numérico a cada cadena.

    /**
     * Constructor parametrizado de la clase. Inicializa un grafo no dirigido y valuado con idexado por cadenas
     * de un tamaño inicial dado
     *
     * @param nVerticesInic: Número de vértices iniciales
     */
    public GrafoNDVIndexCad(int nVerticesInic) {
        super(nVerticesInic);
    }

    /**
     * Añade el nombre de una ciudad a la lista de ciudades que se convertirán en vértices del grafo
     *
     * @param cadena: Cadena con la que indexar un vértice
     */
    public void insertarVertice(String cadena) {
        diccionarioCadenas.add(cadena);
    }

    /**
     * Inserta un arco etiquetado
     *
     * @param vInicio: Vértice inicial
     * @param vFin:    Vertice final
     * @param valor:   Etiqueta del arco
     */
    public void insertarArco(String vInicio, String vFin, float valor) {
        // Obtenemos el índice que ocupa cada String en el diccionario, y lo insertamos en el grafo,
        // (clase padre).
        insertarArco(diccionarioCadenas.indexOf(vInicio), diccionarioCadenas.indexOf(vFin), valor);
    }

    /**
     * Devuelve el valor del arco formado entre dos vértices pasados por parámetro (Strings).
     *
     * @param vInicio: Vértice inicial
     * @param vFin:    Vértice final
     * @return Valor de la etiqueta del arco que une dos vértices
     */
    public float obtenerValorArco(String vInicio, String vFin) {
        // Obtenemos el índice que ocupa cada String en el diccionario y lo buscamos en el grafo,
        // (clase padre).
        return obtenerArco(diccionarioCadenas.indexOf(vInicio), diccionarioCadenas.indexOf(vFin));
    }

    /**
     * Devuelve el conjunto de adyacentes al vértice dado por parámetro.
     *
     * @param vertice: Vértice del que obtener sus adyacentes
     * @return Vértices adyacentes al vértice indicado
     */
    public String[] adyacentes(String vertice) {

        int[] adyacentesNumericos = adyacentes(diccionarioCadenas.indexOf(vertice));    // Obtenemos los vértices.
        String[] verticesString = new String[adyacentesNumericos.length];               // Creamos un vector de igual
        // tamano de Strings

        for (int i = 0; i < adyacentesNumericos.length; i++) {                         // Convertimos cada índice a
            verticesString[i] = diccionarioCadenas.get(adyacentesNumericos[i]);         // String.
        }

        return verticesString;
    }

    /**
     * Devuelve el conjunto de vértices (Strings) que forman el grafo.
     *
     * @return Devuelve el conjunto de vértices del grafo
     */
    public String[] verticesCadena() {

        int[] verticesNumericos = vertices();                                // Obtenemos los vértices (númericos).
        String[] verticesString = new String[verticesNumericos.length];      // Creamos un vector de igual tamano
        // de Strings.

        for (int i = 0; i < verticesNumericos.length; i++) {                   // Convertimos cada índice a String.
            verticesString[i] = diccionarioCadenas.get(verticesNumericos[i]);
        }

        return verticesString;
    }

    /**
     * Devuelve la cadena asociada al índice pasado por parámetro.
     *
     * @param indice Índice asociado a un vértice del grafo y una ciudad
     * @return Cadena equivalente al índice indicado
     */
    private String cadenaEquivalente(int indice) {
        return diccionarioCadenas.get(indice);
    }

    /**
     * Devuelve el índice asociado a la cadena pasada por parámetro.
     *
     * @param cadena Cadena mapeada a un vértice del grafo
     * @return El índice numérico mapeado a una cadena
     */
    private int indiceEquivalente(String cadena) {
        return diccionarioCadenas.indexOf(cadena);
    }

}