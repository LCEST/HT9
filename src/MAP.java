import java.util.Set;

/**
 * Interfaz de MAP
 * @author Luis Esturban
 * @author Gustavo de leon
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
