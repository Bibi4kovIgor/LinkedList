package org.demo;

import org.demo.list.LinkedList;
import org.demo.list.List;
import org.demo.model.Person;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();
        Integer[] array = {45, 78, 123, -87, 1, 0, 6};
        integerList.addAll(array);

        for (Integer integer : integerList) {
            System.out.printf("%d ",integer);
        }
        System.out.println();

        integerList.forEach(System.out::println);

        boolean state = integerList.set(2, 555);
        if (state) {
            System.out.println(integerList);
        } else {
            System.out.println("Element is not exists");
        }

        state = integerList.remove(2);
        if (state) {
            System.out.println(integerList);
        } else {
            System.out.println("Element is not exists");
        }

        state = integerList.removeFirst(-87);
        if (state) {
            System.out.println(integerList);
        } else {
            System.out.println("Element is not exists");
        }

        state = integerList.updateFirst(1, 222);
        if (state) {
            System.out.println(integerList);
        } else {
            System.out.println("Element is not exists");
        }

        System.out.println(integerList.size());

        Integer[] array2 = {2, 11, 3};
        integerList.appendAll(array2);
        System.out.println(integerList.size());
        System.out.println(integerList);
        System.out.println(integerList.getFirst());
        System.out.println(integerList.getLast());

        System.out.println(integerList.getByIndex(2));

        integerList.addByIndex(21, 2);
        integerList.addByIndex(21, 2);
        integerList.addByIndex(21, 2);

        System.out.println(integerList);

        integerList.updateAll(21, 24);
        System.out.println(integerList);

        integerList.sort(true);
        System.out.println(integerList);

        integerList.sort(false);
        System.out.println(integerList);

        Person[] persons = { new Person("Ihor", 1L,31),
                             new Person("Illya", 2L,23)};

        List<Person> personsList = new LinkedList<>();
        personsList.addAll(persons);
        personsList.sort(true);
        System.out.println(personsList);

        personsList.sort(false);
        System.out.println(personsList);

        List<String> stringsList = new LinkedList<>();
        String[] strings = {"qwe", "asd", "dwe"};
        stringsList.addAll(strings);

        stringsList.sortByStringKey("aqd");
        System.out.println(stringsList);

        System.out.println(personsList.stream()
                        .filter(person -> person.getAge() > 30)
                        .toList());

        System.out.println(personsList.stream()
                        .filter(person -> person.getAge() < 24)
                        .toList());

    }
}