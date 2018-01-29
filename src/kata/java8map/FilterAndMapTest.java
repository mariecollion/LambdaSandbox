// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterAndMapTest {

    // Get names of all kids (under age of 18)

    @Test
    public void getAllNamesUnder18ShouldReturnCollectionOfAllKidsNameUnder18(){
        List<Kid> input = Arrays.asList(new Kid("Joe", 20),
                        new Kid("Jane", 12),
                        new Kid("Tom", 23),
                        new Kid("Jack", 13));

        List<String> result = Arrays.asList("Jane", "Jack");

        assertThat(getNamesUnder18(input)).hasSameElementsAs(result);
    }

    private Set<String> getNamesUnder18(List<Kid> input) {
        return input.stream().filter(k -> k.getAge() <= 18).map(Kid::getName).peek(System.out::println).collect(Collectors.toSet());
    }




}

class Kid {

    private String name;
    private int age;

    public Kid(String name, int age) {
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
        if (!(o instanceof Kid)) {
            return false;
        }
        Kid kid = (Kid) o;
        return age == kid.age && Objects.equals(name, kid.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

}



