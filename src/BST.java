import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Clase implementacion binary search tree extendido de Comparable
 * @author Luis Esturban
 * @author Gustavo de leon
 */
public class BST<E extends Comparable<E>>
{
    protected BT<E> root;
    protected BT<E> actionNode;
    protected int size;
    
    public BST()
    {
        root = new BT<>();
        size = 0;
    }
    
    public boolean isEmpty() 
    {
        return root.isEmpty();
    }

    public void clear() 
    {
        root = new BT<>();
        size = 0;
    }
    
    public int size() 
    {
       return size;
    }
    
    public E add(E value)
    {
        E old = null;
        if (root.isEmpty())
        {
            root = new BT<>(value);
            actionNode = root;
            size++;
        }
        else
        {
          BT<E> foundNode = findNode(value, root);
          actionNode = foundNode;
          if(!foundNode.isEmpty())
          {
              old = foundNode.value();
              foundNode.setValue(value);
          }
          else
          {
              foundNode.setValue(value);
              if (foundNode.left()== null)
                  foundNode.setLeft(new BT<>());
              if (foundNode.right()== null)
                  foundNode.setRight(new BT<>());
              size++;
          }
        }
        return old;
    }
    
    public boolean contains(E value)
    {
        return get(value) == null;
    }
    
    public E get(E element)
    {
        if(element == null || root.isEmpty()) return null;
        BT<E> node = findNode(element, root);
        if(node.isEmpty()) return null;
        actionNode = node;
        return node.value();
    }

    public E remove(E value) 
    {
        if(value == null) return null;
        BT<E> foundNode = findNode(value, root);
        if(foundNode.isEmpty()) return null;
        E temp = foundNode.value();
        if(size == 1)
        {
            clear();
            return temp;
        }
        else
        {
            if(foundNode.left().isEmpty()) 
                removeExternal(foundNode.left());
            else if(foundNode.right().isEmpty()) 
                removeExternal(foundNode.right());
            else
            {
                BT<E> rep = foundNode.right();
                while(rep.left().isInternal()) rep = rep.left();
                foundNode.setValue(rep.value());
                removeExternal(rep.left());
                actionNode = foundNode.parent();
            }
        }
        size--;
        return temp;
    }

    public List<E> valuesInOrder()
    {
        List<E> list = new ArrayList<>();
        if(isEmpty()) return list;
        inOrderRecursive(root, list);
        return list;
    }

    protected BT<E> findNode(E value, BT<E> node)
    {
        if(node.isEmpty()) return node;
        else
        {
           int c =  node.value().compareTo(value);
           if (c == 0 )return node;
           else if (c > 0) 
           {
               return findNode(value, node.left());
           }
           else 
           {
              return findNode(value, node.right()); 
           }
        }
    }

    protected void removeExternal(BT<E> v)
    {
        if(!v.isEmpty()) return;
        BT<E> s = null;
        BT<E> p = v.parent();
        if(v.isLeftChild()) s = p.right();
        else s = p.left();
        if(p.parent() != null)
        {
            if(p.isLeftChild()) p.parent().setLeft(s);
            else p.parent().setRight(s);
        }
        else
        {
            root = s;
            root.setParent(null);
        }
    }
    
    protected void inOrderRecursive(BT<E> node, List<E> list)
    {
        if(node.left() != null && !node.left().isEmpty()) 
            inOrderRecursive(node.left(), list);
        list.add(node.value());
        if(node.right() != null && !node.right().isEmpty()) 
            inOrderRecursive(node.right(), list);
    }
}
