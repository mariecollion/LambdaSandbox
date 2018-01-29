// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MaxAndComparatorTest {

    // Get the oldest person of the collection
    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        List<Person> input = Arrays.asList(new Person("Joe", 20),
                        new Person("Jane", 12),
                        new Person("Tom", 23),
                        new Person("Jack", 30));

        Person result = new Person("Jack", 30);

       assertThat(getOldestPerson(input)).isEqualToComparingFieldByField(result);
        assertThat(getOldestPersonUsingComparable(input)).isEqualToComparingFieldByField(result);
        assertThat(getOldestPersonOldWay(input)).isEqualToComparingFieldByField(result);
    }



    private Person getOldestPerson(List<Person> personsList) {
       // return personsList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).findFirst();
        return personsList.stream().max(Comparator.comparing(Person::getAge)).get();
    }

    private Person getOldestPersonUsingComparable(List<Person> personsList){
        Collections.sort(personsList);
        return personsList.get(0);
    }

    private Person getOldestPersonOldWay(List<Person> personsList){
        Person oldest = personsList.get(0);
        for (Person p : personsList){
            if (oldest.getAge() < p.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }

}



class Person implements Comparable<Person> {

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
