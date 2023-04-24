package org.demo;

import org.demo.list.LinkedList;
import org.demo.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();
        integerList.add(12);
        integerList.add(13);
        integerList.add(121);
        integerList.add(1);
        System.out.println(integerList);
        integerList.addByIndex(4,3);
        System.out.println(integerList);
        integerList.addByIndex(-11,2);
        System.out.println(integerList);
        integerList.addByIndex(77,0);
        System.out.println(integerList);
        integerList.addByIndex(222, integerList.size());
        System.out.println(integerList);

        Integer[] array = {45, 78, 123, -87, 1, 0, 6};
        integerList.addAll(array);
        System.out.println(integerList);

        Integer[] array2 = {2, 11, 3};
        integerList.appendAll(array2);
        System.out.println(integerList);


    }
}