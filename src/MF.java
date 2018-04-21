
/**
 *
 * @author Luis
 */
public class MF {
    
    static <K extends Comparable<K>,V> MAP<K,V> getMap(String map) {
        if (map.equalsIgnoreCase("RedBlack")) {
            return new MRB<K,V>();
        } else if (map.equalsIgnoreCase("Splay")){
            return new MST<K,V>();
        }
        return null;
    }
}