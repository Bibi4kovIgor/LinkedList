package org.demo.list;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private List<Integer> integerList;
    private static final Integer[] ARRAY_DATA = {12, 47, 12, 96, 1, 7};

    @BeforeEach
    void createAndFillList(){
        integerList = new LinkedList<>();
    }

    @Test
    void iterator() {
    }

    @Test
    void size() {
    }

    @Test
    void addElementToList_addFirstElement_ElementWasAdded() {
        // Arrange
        int expected = 10;

        // Act
        integerList.add(expected);
        int actual = integerList.getFirst();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void addElementToList_addLastElement_ElementWasAdded() {
        // Arrange
        integerList.addAll(ARRAY_DATA);
        int expected = 7;

        // Act
        integerList.add(expected);
        int actual = integerList.getLast();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void addAll() {
    }

    @Test
    void addByIndex() {
    }

    @Test
    void testToString() {
    }

    @Test
    void toArray() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void updateFirst() {
    }

    @Test
    void appendAll() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void set() {
    }

    @Test
    void updateAll() {
    }

    @Test
    void getByIndex() {
    }

    @Test
    void sort() {
    }

    @Test
    void sortByStringKey() {
    }

    @Test
    void stream() {
    }
}