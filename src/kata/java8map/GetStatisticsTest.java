// Copyright (c) 2018 Travelex Ltd

package kata.java8map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;

public class GetStatisticsTest {

    // Get people statistics: average age, count, maximum age, minimum age and sum of all ages.

    Person Shepard = new Person("shepard", 32);
    Person Liara = new Person("liara", 109);
    Person Aria = new Person("aria", 1000);
    Person Anderson = new Person("anderson", 53);
    Person Mordin = new Person("mordin", 35);

    Collection<Person> persons = new ArrayList<>();
    {
        persons.add(Anderson);
        persons.add(Liara);
        persons.add(Aria);
        persons.add(Shepard);
        persons.add(Mordin);
    }

    @Test
    public void getStatsShouldReturnAverageAge() {
        assertThat(getStats(persons).getAverage()).isEqualTo(Double.valueOf(245.8));
    }

    @Test
    public void getStatsShouldReturnCountOfPersons() {
        assertThat(getStats(persons).getCount()).isEqualTo(5);
    }

    @Test
    public void getStatsShouldReturnMaxAge() {
        assertThat(getStats(persons).getMax()).isEqualTo(1000);
    }

    @Test
    public void getStatsShouldReturnMinAge() {
        assertThat(getStats(persons).getMin()).isEqualTo(32);
    }

    @Test
    public void getStatsShouldReturnSumAllAge() {
        assertThat(getStats(persons).getSum()).isEqualTo(1229);
    }


    private IntSummaryStatistics getStats(Collection<Person> persons){
       return persons.stream().mapToInt(Person::getAge).summaryStatistics();
    }



}
