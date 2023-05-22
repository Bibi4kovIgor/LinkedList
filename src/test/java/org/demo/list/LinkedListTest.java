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
    void sizeOfList_getListSize_returnIntegerValueOfSize() {
        int expectedSize = 6;
        integerList.addAll(ARRAY_DATA);
        int actualSize = integerList.size();
        assertEquals(expectedSize, actualSize);
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
    void addByIndexElementToList_addFirstElement_ElementWasAdded() {
        // Arrange
        integerList.addAll(ARRAY_DATA);
        int expected = 7;

        // Act
        integerList.addByIndex(expected, 0);
        int actual = integerList.getFirst();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void addByIndexElementToList_addElementBySpecifiedIndex_Throws() {
        // Arrange
        integerList.addAll(ARRAY_DATA);
        int value = 1;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.addByIndex(value, -1));
    }



    @Test
    void addAll() {
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