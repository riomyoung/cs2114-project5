package prj5;

import bag.Node;
import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {
    
    private Node<T> firstNode;
    
    public LinkedList()
    {
    }

    public int size() 
    {
        return 0;
    }

    @Override
    public void add(int index, Object obj) {
        
    }

    @Override
    public void add(Object obj) {
        
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public boolean remove( T item ) {
        return false;
    }



    public T get(int index) {
        return null;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public void clear() {
        
    }


    @Override
    public T getEntry(int index) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T replace(int index, T item) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

}
