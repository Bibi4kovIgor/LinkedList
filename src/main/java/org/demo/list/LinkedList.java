package org.demo.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class LinkedList<T> implements List<T> {

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(T o) {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private final class ListIterator implements Iterator<T> {
        private Node<T> current;
        private int index;

        public ListIterator() {
            this.current = first;
            index = 0;
        }


        @Override
        public boolean hasNext() {
            if (Objects.isNull(current)) {
                throw new NoSuchElementException("List is empty iteration is not accessible");
            }

            return Objects.nonNull(current.next);
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new IllegalArgumentException("Element doesn't exists");
            }

            if(index == 0) {
                index++;
                return first.value;
            }

            current = current.next;
            index++;
            return current.value;
        }
    }


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

    /**
     * @param index
     * @param newValue
     * @return
     */
    @Override
    public boolean set(int index, T newValue) {
        return false;
    }

    /**
     * @param oldValue
     * @param newValue
     * @return
     */
    @Override
    public boolean updateAll(T oldValue, T newValue) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public Stream<T> stream() {
        return null;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public T getElementByIndex(int index) {
        return null;
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
    public boolean updateFirst(T oldValue, T newValue) {
        // TODO: add implementation
        return false;
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

    /**
     * @param order
     */
    @Override
    public void sort(boolean order) {

    }

    /**
     *
     * Add element to current position
     * if you add element to the 3-rd position and your list has 5 elements at all,
     * then you'll move element on 3-rd position to the 4-rd and new element will be added to the 3-rd position.
     * So, you'll probably work with previous element's pointer.
     * */
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
