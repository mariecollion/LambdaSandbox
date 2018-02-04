// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static java.util.stream.Collectors.partitioningBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionTest {

    // Partition adults and kids

    @Test
    public void partitionAdultShouldSeparateAdultsAndKids() {
        Person Joe = new Person("Joe", 20);
        Person Jane = new Person("Jane", 12);
        Person Tom = new Person("Tom", 23);
        Person Jack = new Person("Jack", 30);
        List<Person> input = new ArrayList<>();
        input.add(Joe);
        input.add(Jane);
        input.add(Tom);
        input.add(Jack);

        Map<Boolean, List<Person>> expected = new HashMap<>();
        expected.put(true, Arrays.asList(Joe, Tom, Jack));
        expected.put(false, Arrays.asList(Jane));

        assertThat(partitionAdult(input)).isEqualTo(expected);


    }


    private Map<Boolean, List<Person>> partitionAdult(List<Person> persons) {
        return persons.stream().collect(partitioningBy(p -> p.getAge() >= 18));
    }

}
