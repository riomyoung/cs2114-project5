package prj5;

import bag.Node;
import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {
    
    private Node<T> firstNode;
    private int size;
    
    public LinkedList()
    {
        firstNode = null;
        size = 0;
    }

    public int size() 
    {
        return size;
    }

    @Override
    public void add(int index, T element) {
        
    }

    @Override
    public void add(T item) 
    {
        if (item == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = firstNode;

        // empty stack case
        if (isEmpty()) {
            firstNode = new Node<T>(item);
        }

        // other cases
        else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(item));
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
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
    public T getEntry(int index) 
    {
        Node<T> current = firstNode;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.getData();
            }
            currentIndex++;
            current = current.getNext();
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
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
