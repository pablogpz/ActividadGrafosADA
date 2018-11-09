import java.util.ArrayList;

/**
 * Clase que modela un grafo no dirigido valuado (con etiquetas positivas y que toman valores reales no negativos)
 * con indexación de cadenas en lugar de indexacion de enteros.
 * Permite asociar el nombre de las ciuades a los vértices del grafo
 *
 * @author Juan Pablo García Plaza Pérez - Jose Ángel Concha Carrasco
 */
public class GrafoNDVIndexCad extends GrafoNDV {

    /**
     * Colección de nombres de ciudades del mapa de carreteras. Permite establecer un índice numérico único a cada ciudad
     */
    private ArrayList<String> diccionarioCiudades;

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
     * @param nombreCiudad Nombre de la ciudad a registrar
     */
    public void añadirCiudad(String nombreCiudad) {
        // TODO - implement GrafoNDVIndexCad.añadirCiudad
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
     * @return El nombre de la ciudad equivalente al índice indicado
     */
    private String ciudadEquivalente(int indice) {
        // TODO - implement GrafoNDVIndexCad.ciudadEquivalente
        return null;
    }

    /**
     * @param nombreCiudad Nombre de la ciudad mapeada a un vértice del grafo
     * @return El índice numérico mapeado al nombre de una ciudad
     */
    private int indiceEquivalente(String nombreCiudad) {
        // TODO - implement GrafoNDVIndexCad.indiceEquivalente
        return 0;
    }

}