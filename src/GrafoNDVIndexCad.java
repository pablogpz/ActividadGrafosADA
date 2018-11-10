import java.util.ArrayList;

/**
 * Clase que modela un grafo no dirigido valuado (con etiquetas positivas y que toman valores reales no negativos)
 * con indexación de cadenas en lugar de indexacion de enteros.
 *
 * @author Juan Pablo García Plaza Pérez - Jose Ángel Concha Carrasco
 */
public class GrafoNDVIndexCad extends GrafoNDV {

    /**
     * Colección cadenas. Permite establecer un índice numérico único a cada cadena
     */
    private ArrayList<String> diccionarioCadenas;

    /**
     * Constructor parametrizado de la clase. Inicializa un grafo no dirigido y valuado con idexado por cadenas
     * de un tamaño inicial dado
     *
     * @param nVerticesInic Número de vértices inciales
     */
    public GrafoNDVIndexCad(int nVerticesInic) {
        super(nVerticesInic);
        // TODO - implement GrafoNDVIndexCad.GrafoNDVIndexCad
    }

    /**
     * Añade el nombre de una ciudad a la lista de ciudades que se convertirán en vértices del grafo
     *
     * @param cadena Cadena con la que indexar un vértice
     */
    public void añadirVertice(String cadena) {
        // TODO - implement GrafoNDVIndexCad.añadirCiudad
    }

    /**
     * Inserta un arco etiquetado
     *
     * @param vInicio Vértice inicial
     * @param vFin    Vertice final
     * @param valor   Etiqueta del arco
     */
    public void añadirArco(String vInicio, String vFin, float valor) {

    }

    /**
     * @return Devuelve el conjunto de vértices del grafo
     */
    public int[] vertices() {
        // TODO - implement GrafoNDVIndexCad.vertices
        return new int[0];
    }

    /**
     * @param indice Índice asociado a un vértice del grafo y una ciudad
     * @return Cadena equivalente al índice indicado
     */
    private String cacenaEquivalente(int indice) {
        // TODO - implement GrafoNDVIndexCad.ciudadEquivalente
        return null;
    }

    /**
     * @param cadena Cadena mapeada a un vértice del grafo
     * @return El índice numérico mapeado a una cadena
     */
    private int indiceEquivalente(String cadena) {
        // TODO - implement GrafoNDVIndexCad.indiceEquivalente
        return 0;
    }

}