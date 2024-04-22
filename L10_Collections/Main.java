package L10_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A", 2));
        persons.add(new Person("B", 3));
        persons.add(new Person("C", 1));
        persons.add(new Person("D", 8));

        Collections.sort(persons);

        Comparator<Person> comparator = new Compare();

        Collections.sort(persons, comparator);

        System.out.println(persons);
    }
}



class Person implements Comparable<Person> {

    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Compare implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.age - p1.age;
    }
}


