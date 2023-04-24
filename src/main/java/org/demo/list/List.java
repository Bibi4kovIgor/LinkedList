package org.demo.list;

public interface List<T> {
    void add(T element);
    void addAll(T[] array);
    void appendAll(T[] array);

    int size();

    void addByIndex(T element, int position);
    boolean remove(T element);
    boolean removeFirst();
    T getFirst();
    T getLast();
    boolean update(T oldValue, T newValue);
    Object[] getAll();
    T getElementByIndex();
}
