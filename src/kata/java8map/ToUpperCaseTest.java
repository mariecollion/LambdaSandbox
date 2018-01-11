// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToUpperCaseTest {

    /*
            Convert elements of a collection to upper case.
 */


    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {

        List<String> collection = Arrays.asList("My", "Name", "Is", "John", "Doe");
        List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }



    public List<String> transform(List<String> collection) {
        if (collection == null) throw new IllegalArgumentException("empty list");
        collection = collection.stream().map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());

        return collection;
    }

}
