
/**
 *Clase con el Map factory
 * @author Luis Esturban
 * @author Gustavo de leon
 */
public class MF {
    
    static <K extends Comparable<K>,V> MAP<K,V> getMap(String map) {
        if (map.equalsIgnoreCase("1")) {
            return new MRB<K,V>();
        } else if (map.equalsIgnoreCase("2")){
            return new MST<K,V>();
        }
        return null;
    }
}