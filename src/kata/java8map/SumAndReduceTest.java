// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SumAndReduceTest {

    // Sum all elements of a collection

    @Test
    public void getSumShouldSumInputNumbers() {
        List<Integer> input = Arrays.asList(5, 3, 9, 11, 1, 7);
        int sum = 36;
        assertThat(getSumAndReduce(input)).isEqualTo(sum);
    }

    public int getSumAndReduce(List<Integer> intToSum) {
        return intToSum.stream().reduce(0, (a, b) -> a+b);
    }
}
