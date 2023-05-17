package org.demo.list;

import org.demo.exception.ListIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedList<E extends Comparable<? super E>> implements List<E> {

    Logger logger = LoggerFactory.getLogger(String.format("Ihor Bibichkov class: %s", LinkedList.class));

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private Comparator<E> reverseComparator() {
        return new ReversedListComparator();
    }

    private Comparator<E> comparator() {
        return new ListComparator();
    }

    private final class ListIterator implements Iterator<E> {
        private Node<E> current;
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
        public E next() {

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


    private final class ListComparator implements Comparator<E> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(E o1, E o2) {
            return o1.compareTo(o2);
        }

/*        *//**
         * Returns a comparator that imposes the reverse ordering of this
         * comparator.
         *
         * @return a comparator that imposes the reverse ordering of this
         * comparator.
         * @since 1.8
         */
        @Override
        public Comparator<E> reversed() {
            return new ReversedListComparator();
        }
    }
    private final class ReversedListComparator implements Comparator<E> {
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(E o1, E o2) {
            return o2.compareTo(o1);
        }

        /**
         * Returns a comparator that imposes the reverse ordering of this
         * comparator.
         *
         * @return a comparator that imposes the reverse ordering of this
         * comparator.
         * @since 1.8
         */
        @Override
        public Comparator<E> reversed() {
            return new ListComparator();
        }
    }

    private record CompareByStringKey(String sortKey) implements Comparator<String> {

    /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param str1 the first object to be compared.
         * @param str2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(String str1, String str2) {
            int pos1 = 0;
            int pos2 = 0;

            for (int i = 0; i < Math.min(str1.length(), str2.length()) && pos1 == pos2; i++) {
                pos1 = sortKey.indexOf(str1.charAt(i));
                pos2 = sortKey.indexOf(str2.charAt(i));
            }

            if (pos1 == pos2 && str1.length() != str2.length()) {
                return str1.length() - str2.length();
            }

            return pos1 - pos2;
        }
    }

    private static final class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(E value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        public Node() {
            this.value = null;
            this.previous = null;
            this.next = null;
        }
    }

    private Node<E> first;
    private Node<E> last;
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
    public void add(E value) {
        if (size == 0) {
            addElementToFirstPosition(value);
        } else {
            addElementToLastPosition(value);
        }
    }


    @Override
    public void addAll(E[] array) {
        try {
            checkEmptyArray(array);
        } catch (ListIsEmptyException e) {
            logger.warn(e.getMessage());
            return;
        }

        clear();

        for (E value : array) {
            add(value);
        }
    }

    private void checkEmptyArray(E[] array) throws ListIsEmptyException {
        if (Objects.isNull(array) || array.length == 0) {
            throw new ListIsEmptyException("Internal array is empty or null");
        }
    }

    @Override
    public void addByIndex(E value, int position) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
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
        return Arrays.asList(toArray()).toString();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)){
            result[i] = temp.value;
            temp = temp.next;
            i++;
        }
        return result;
    }

    @Override
    public boolean remove(int index) {
        if(checkEmptyList(index)) {
            return false;
        }

        if (size == 1) {
            first = last = null;
        }

        if (index == 0) {
            removeFirstElement();
            return true;
        }

        if (index == size -1) {
            removeLastElement();
            return true;

        }

        Node<E> element = getElementByIndex(index);
        Node<E> previous = element.previous;
        Node<E> next = element.next;

        previous.next = element.next;
        next.previous = previous;
        element.previous = null;

        size--;
        return true;
    }

    private boolean checkEmptyList(int index) {
        if (index <= 0 || index > size) {
            logger.warn("Try to remove element with not existed index");
            return true;
        }
        return false;
    }

    private void removeLastElement() {
        Node<E> removedElement = last;
        last = last.previous;
        removedElement.previous = null;
        last.next = null;
        size--;
    }

    private void removeFirstElement() {
        Node<E> removedElement = first;
        first = first.next;
        removedElement.next = null;
        first.previous = null;
        size--;
    }

    @Override
    public boolean removeFirst(E value) {
        int index = getElementByValue(value);
        if (index < 0 || isEmptyList()) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public boolean updateFirst(E oldValue, E newValue) {
        if (isEmptyList()) {
            return false;
        }

        int index = getElementByValue(oldValue);

        if (index < 0) {
            return false;
        }

        set(index, newValue);
        return true;
    }

    /**
     *
     * This method should append elements to existed list
     * All new elements should be placed to the end of list
     *
     */
    @Override
    public void appendAll(E[] array) {
        for (E value : array) {
            add(value);
        }
    }


    @Override
    public E getFirst() {
        if (isEmptyList()) {
            return new Node<E>().value;
        }

        return first.value;
    }

    @Override
    public E getLast() {
        if (isEmptyList()) {
            return new Node<E>().value;
        }

        return last.value;
    }

    @Override
    public boolean set(int index, E newValue) {
        if (index < 0 || index > size || isEmptyList()) {
            return false;
        }

        Node<E> element = getElementByIndex(index);
        element.value = newValue;
        return true;
    }


    @Override
    public void updateAll(E oldValue, E newValue) {
        if (isEmptyList()) {
            return;
        }

        Node<E> temp = first;
        for(int i = 0; i < size; i++) {
            if (Objects.equals(temp.value, oldValue)) {
                set(i, newValue);
            }
            temp = temp.next;
        }
    }

    @Override
    public E getByIndex(int index) {
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    /**
    *
      */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void sort(boolean order) {
        Object[] array = toArray();

        if (order) {
            Arrays.sort(array, (Comparator) comparator());
        } else {
            Arrays.sort(array, (Comparator) reverseComparator());
        }

        for (int i = 0; i < array.length; i++) {
            set(i, (E)array[i]);
        }
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void sortByStringKey(String key) {
        Object[] array = toArray();
        Arrays.sort(array, (Comparator) new CompareByStringKey(key));
        for (int i = 0; i < array.length; i++) {
            set(i, (E) array[i]);
        }
    }

    @Override
    public Stream<E> stream() {
        Spliterator<E> spliterator = Spliterators.spliteratorUnknownSize(iterator(), Spliterator.SIZED);
        return StreamSupport.stream(spliterator, true);
    }

    private void addElementToLastPosition(E value) {
        Node<E> newNode = new Node<>(value, null, last);
        last.next = newNode;
        last = newNode;
        size++;
    }

    private void addElementToFirstPosition(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    private boolean isEmptyList(){
        return Objects.isNull(first);
    }


    /**
     *
     * Add element to current position
     * if you add element to the 3-rd position and your list has 5 elements at all,
     * then you'll move element on 3-rd position to the 4-rd and new element will be added to the 3-rd position.
     * So, you'll probably work with previous element's pointer.
     * */
    private void addElementToMiddlePosition(E value, int position) {
        Node<E> temp = first;
        Node<E> newNode = new Node<>(value);
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.previous = temp.previous;
        size++;
    }

    private Node<E> getElementByIndex(int index) {
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private int getElementByValue(E value) {
        Node<E> temp = first;
        for(int i = 0; i < size; i++) {
            if (temp.value.equals(value)) {
                return i;
            }
            temp = temp.next;
        }
        return Integer.MIN_VALUE;
    }


    private void clear() {
        first = last = null;
        size = 0;
    }


}
