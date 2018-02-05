// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningTest {

    // Return people names separated by comma


    @Test
    public void joiningPersonsShouldSeparatePersonByComma() {
        List<Person> input = Arrays.asList(new Person("Joe", 20),
                        new Person("Jane", 12),
                        new Person("Tom", 23),
                        new Person("Jack", 30));

        String expected = "Joe, Jane, Tom, Jack";

        Assertions.assertThat(joiningPersonNameByComma(input)).isEqualTo(expected);
    }


    public String joiningPersonNameByComma(List<Person> persons) {
       return persons.stream().map(Person::getName).collect(Collectors.joining(", "));
    }

}
