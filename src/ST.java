
/**
 * Clase con Splay Tree Extendiendo Binary Search Tree
 * @author Luis Esturban
 * @author Gustavo de leon
 * Extraido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 */
public class ST<E extends Comparable<E>> 
        extends BST<E>
{
    public E add(E value)
    {
        E old = super.add(value);
        splay(actionNode);
        return old;
    }
    
    public E remove(E element)
    {
        E old = super.remove(element);
        if(actionNode != null) splay(actionNode);
        return old;
    }
    
    public boolean contains(E element)
    {
        boolean b = super.contains(element);
        if(b) splay(actionNode);
        return b;
    }
    
    public E get(E element)
    {
        E e = super.get(element);
        if(e != null) splay(actionNode);
        return e;
    }
    protected void splay(BT<E> node)
    {
        if(node.equals(root) || node == null) return;
        BT<E> gp = null;
        BT<E> p = null;
        boolean hasGp = false;
        while(node.parent() != null)
        {
            p = node.parent();
            if(p != null) gp = p.parent();
            hasGp = gp != null;
            if (node.isLeftChild()) {
                if (hasGp)
                {
                    if (p.isLeftChild())
                    {
                        gp.rotateRight();
                        p.rotateRight();
                    } else
                    {
                        p.rotateRight();
                        gp.rotateLeft();
                    }
                } else 
                {                    
                    p.rotateRight();
                }
            } 
            else 
            {
                if (hasGp) 
                {
                    if (p.isLeftChild()) 
                    {
                        p.rotateLeft();
                        gp.rotateRight();
                    } else 
                    {
                        gp.rotateLeft();
                        p.rotateLeft();
                    }
                } else 
                {                    
                    p.rotateLeft();
                }
            }


        }
        root = node;
    }
}