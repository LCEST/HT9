import java.util.Set;

/**
 * mapas
 * @author Luis
 */
public interface MAP<K,V>
{
    
    public int size();

    
    public boolean isEmpty();

    
    public V get(K k);

    
    public V put(K k, V v);


    
    public boolean equals(Object other);
    
    
    public int hashCode();
}
