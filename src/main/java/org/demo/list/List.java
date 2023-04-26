package org.demo.list;

import java.util.stream.Stream;

public interface List<T> extends Iterable<T>, Comparable<T> {
    void add(T element);
    void addAll(T[] array);
    void appendAll(T[] array);

    int size();

    void addByIndex(T element, int position);
    boolean remove(T element);
    boolean removeFirst();
    T getFirst();
    T getLast();
    boolean updateFirst(T oldValue, T newValue);
    boolean set(int index, T newValue);
    boolean updateAll(T oldValue, T newValue);
    Object[] getAll();
    T getElementByIndex(int index);
    /**
     * Default - ASC
     * if @order == false -> DESC
     * */
    void sort(boolean order);

    Stream<T> stream();
}
