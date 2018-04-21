import java.util.Map.Entry;


/**
 * Clase con el Splay Tree Map implementando MAP
 * @author Luis Esturban
 * @author Gustavo de leon
 */
public class MST<K extends Comparable<K>,V> implements MAP<K, V>{
    protected ST<SE<K,V>> tree;
    
    public MST()
    {
        tree = new ST<>();
    }
    
    public V put(K key, V value)
    {
        SE<K,V> old = tree.add(new SE<>(key, value));
        if(old == null) return null;
        return old.getValue();
    }
    
    public V remove(K key)
    {
        SE<K,V> temp = tree.remove(new SE<>(key, null));
        if(temp == null) return null;
        return temp.getValue();
    }
    
    public boolean contains(K key)
    {
        SE<K,V> temp = tree.get(new SE<>(key, null));
        if(temp == null) return false;
        return temp.getValue() != null;
    }
    
    public V get(K key)
    {
        SE<K,V> temp = tree.get(new SE<>(key, null));
        if(temp == null) return null;
        return temp.getValue();
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected static class SE<K extends Comparable<K>,V> 
            implements Entry<K,V>, Comparable<SE<K,V>>
    {
        protected K key;
        protected V value;
        
        public SE(K k, V v)
        {
            key = k;
            value = v;
        }
        
        @Override
        public K getKey() 
        {
            return key;
        }

        @Override
        public V getValue() 
        {
            return value;
        }

        @Override
        public V setValue(V value) 
        {
            V temp = value;
            this.value = value;
            return temp;
        }

        @Override
        public int compareTo(SE<K, V> o) 
        {
            return key.compareTo(o.getKey());
        }
    }
}