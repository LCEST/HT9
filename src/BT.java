
/**
 * binary tree
 * @author Luis
 */
public class BT<E>
{
    protected E value;
    protected BT<E> parent, left, right;
    
    public BT()
    {
        value = null;
        parent = left = right = null;
    }
    
    public BT(E value)
    {
        this.value = value;
        setLeft(new BT<>());
        setRight(new BT<>());
    }
    
    public BT(E value, BT<E> left, BT<E> right)
    {
        this(value);
        if(left != null) setLeft(left); 
        if(right != null) setRight(right);
    }
    
    public BT<E> left() { return left; }
    public BT<E> right() { return right; }
    public BT<E> parent() { return parent; }

    public void setLeft(BT<E> newLeft) 
    {
        left = newLeft;
        newLeft.setParent(this);
    }

    public void setRight(BT<E> newRight)
    {
        right = newRight;
        newRight.setParent(this);
    }
    
    public boolean isLeftChild()
    {
        if(parent != null)
        {
            BT left = parent.left();
            return this == left;
        }
        return false;
    }
    
    public boolean isRightChild() 
    {
        if(parent != null)
        {
            BT right = parent.right();
            return this == right;
        }
        return false;
    }

    public boolean isInternal()
    {
        return ((left() != null) || (right != null));
    }

    public E value() { return value; }
    
    public void setValue(E newValue) { value = newValue; }
    
    protected void setParent(BT<E> newParent) 
    {
        parent = newParent;
    }

    protected boolean isEmpty()
    {
        return value == null;
    }

    protected BT<E> rotateRight()
    {
        BT<E> newRoot = left();
        if(newRoot == null) return this;
        BT<E> tempParent = this.parent();
        boolean isLeft = this.isLeftChild();
        setLeft(newRoot.right());
        newRoot.setRight(this);
        if(tempParent != null)
        {
            if(isLeft) tempParent.setLeft(newRoot);
            else tempParent.setRight(newRoot);
        }
        else newRoot.setParent(null);
        return newRoot;
    }
    
    protected BT<E> rotateLeft()
    {
        BT<E> newRoot = this.right();
        if(newRoot == null) return this;
        BT<E> tempParent = this.parent();
        boolean isLeft = this.isLeftChild();
        setRight(newRoot.left());
        newRoot.setLeft(this);
        if(tempParent != null)
        {
            if(isLeft) tempParent.setLeft(newRoot);
            else tempParent.setRight(newRoot);
        }
        else newRoot.setParent(null);
        return newRoot;
    }
}
