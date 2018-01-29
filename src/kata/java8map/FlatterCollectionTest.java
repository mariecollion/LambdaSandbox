// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatterCollectionTest {

    // Flatten multidimensional collection

    @Test
    public void flattenShouldTransformToUnidimensionalCollection(){
        List<List<String>> input = Arrays.asList(Arrays.asList("Punk IPA", "A new hop"), Arrays.asList("Cooper", "Little Creature"), Arrays
                        .asList("Dude", "Kurt"));
        List<String> result = Arrays.asList("Punk IPA", "A new hop", "Cooper", "Little Creature", "Dude", "Kurt");
        assertThat(flatten(input)).hasSameElementsAs(result);

    }


    private List<String> flatten(List<List<String>> input) {
        return input.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
    }

}
