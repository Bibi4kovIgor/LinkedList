package org.demo.list;

import java.util.stream.Stream;

public interface List<E> extends Iterable<E> {
    void add(E element);
    void addAll(E[] array);
    void appendAll(E[] array);

    int size();

    void addByIndex(E element, int position);
    boolean remove(int index);
    boolean removeFirst(E value);
    E getFirst();
    E getLast();
    boolean updateFirst(E oldValue, E newValue);
    boolean set(int index, E newValue);
    void updateAll(E oldValue, E newValue);
    Object[] toArray();
    E getByIndex(int index);
    Stream<E> stream();
    void sort(boolean order);
    void sortByStringKey(String key);
}
