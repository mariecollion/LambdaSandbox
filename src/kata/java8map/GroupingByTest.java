// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest {

    // Group people by nationality


    @Test
    public void groupingByNationalityShouldGroupPersonByNationality() {
        Person Joe = new Person("Joe", 20, "USA");
        Person Jane = new Person("Jane", 12, "Canada");
        Person Tom = new Person("Tom", 23, "Canada");
        Person Jack = new Person("Jack", 30, "UK");

        List<Person> input = new ArrayList<>();
        input.add(Joe);
        input.add(Jane);
        input.add(Tom);
        input.add(Jack);

        Map<String, List<Person>> expected = new HashMap<>();
        expected.put("USA", Arrays.asList(Joe));
        expected.put("Canada", Arrays.asList(Jane, Tom));
        expected.put("UK", Arrays.asList(Jack));

        assertThat(groupingByNationality(input)).isEqualTo(expected);
    }


    public Map<String, List<Person>> groupingByNationality(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getNationality));
    }

}
