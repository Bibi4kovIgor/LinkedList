package org.demo.list;

import java.util.Arrays;
import java.util.Objects;

public class LinkedList<T> implements List<T> {

    private static final class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;


    public LinkedList() {
        this.first = null;
        this.last = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            addElementToFirstPosition(value);
        } else {
            addElementToLastPosition(value);
        }
    }

    @Override
    public void addAll(T[] array) {
        clear();
        addAllElements(array);
    }

    @Override
    public void addByIndex(T value, int position) {
        if (position > size || position < 0) {
            return;
        }

        if (position == 0) {
            addElementToFirstPosition(value);
        } else if (position == size) {
            addElementToLastPosition(value);
        } else {
            addElementToMiddlePosition(value, position);
        }

    }

    @Override
    public String toString() {
        return Arrays.asList(getAll()).toString();
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[size];
        Node<T> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)){
            result[i] = temp.value;
            temp = temp.next;
            i++;
        }
        return result;
    }

    /**
     *
     * This is homework!
     * TODO: implement all needed methods
     *
     */
    @Override
    public boolean remove(T value) {
        // TODO: add implementation
        return false;
    }

    @Override
    public boolean update(T oldValue, T newValue) {
        // TODO: add implementation
        return false;
    }

    @Override
    public T getElementByIndex() {
        // TODO: add implementation
        return null;
    }

    /**
     *
     * This method should append elements to existed list
     * All new elements should be placed to the end of list
     *
     */
    @Override
    public void appendAll(T[] array) {
        // TODO: implement method
    }

    @Override
    public boolean removeFirst() {
        // TODO: implement method
        return false;
    }

    @Override
    public T getFirst() {
        // TODO: implement method
        return null;
    }

    @Override
    public T getLast() {
        // TODO: implement method
        return null;
    }

    private void addElementToLastPosition(T value) {
        Node<T> newNode = new Node<>(value, null, last);
        last.next = newNode;
        last = newNode;
        size++;
    }

    private void addElementToFirstPosition(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    private void addElementToMiddlePosition(T value, int position) {
        Node<T> temp = first;
        Node<T> newNode = new Node<>(value);
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.previous = temp.previous;
        size++;
    }
    private void addAllElements(T[] array) {
        for (T value : array) {
            if(size == 0) {
                addElementToFirstPosition(value);
                continue;
            }
            addElementToLastPosition(value);
        }
    }


    private void clear() {
        first = last = null;
        size = 0;
    }

}
