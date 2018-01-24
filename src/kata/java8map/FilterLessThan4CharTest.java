// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterLessThan4CharTest {

    /*
        Filter collection so that only elements with less than 4 characters are returned.
     */


    @Test
    public void filterCollectionShouldFilterFromCollectionLessThan4CharWords() {

        List<String> collection = Arrays.asList("Beer", "punkIPA", "IBU", "ArrogantBastardIPA");
        List<String> result = Arrays.asList("IBU");
        assertThat(filterCollection(collection)).hasSameElementsAs(result);

    }


    public List<String> filterCollection(List<String> collection) {
        return collection.stream().filter(s -> s.length() < 4).peek(System.out::println).collect(Collectors.toList());
    }

}
