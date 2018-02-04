// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import java.util.Objects;

public class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person p) {
        if (p == null) return -1;
        if (getAge() > p.getAge()) return -1;
        else if (getAge() == p.getAge()) return 0;
        else return 1;
    }

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
