
/**
 *Clase con  Red black Map implementando MAP
 * @author Luis Esturban
 * @author Gustavo de leon
 */
public class MRB<K extends Comparable<K>, V> implements MAP<K, V> {
    private RB<K,V> data;

    public MRB() {
        data = new RB<K, V>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public V get(K k) {
        return data.get(k);
    }

    @Override
    public V put(K k, V v) {
        data.put(k,v);
        return null;
    }
}
