import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {



    // Lambda testing


    public static void main(String[] args) {


        // Predicate takes one parameter as input and return a boolean value (BiPredicate: 2 inputs)

        Predicate<String> methodRef = String::isEmpty;
        Predicate<String> testS = s -> s.isEmpty();

        String s = "blabla";

        System.out.println(methodRef.test(s));
        System.out.println(testS.test(s));


        String s2 = "";

        System.out.println(methodRef.test(s2));
        System.out.println(testS.test(s2));



        // Supplier takes no input and return a value. Useful to create object

        Supplier<String> s1 = String::new;
        Supplier<String> s3 = () -> new String(s);

        System.out.println(s1.get());
        System.out.println(s3.get());



        // Consumer is used to do something with a parameter without returning anything (BiConsumer: 2 inputs)
        ArrayList<String> l = new ArrayList<>();
        l.add("ellen ripley");
        l.add("jane shepard");
        Consumer<Integer> c1 = System.out::println;
        Consumer<Integer> c2 = x -> System.out.println(x);
        c1.accept(l.size());
        c2.accept(l.indexOf("jane shepard"));



        Predicate<String> egg = st -> st.contains("egg");
        Predicate<String> brown = st -> st.contains("brown");

        Predicate<String> brownEgg = egg.and(brown);
        Predicate<String> otherEgg = egg.and(brown.negate());

        System.out.println(brownEgg.test("brown egg"));
        System.out.println(brownEgg.test("other egg"));
        System.out.println(otherEgg.test("other egg"));



        // Function/BiFunction: can potentially turn one/two value(s) into another value of another type and return it.
        BiFunction<String, String, String> concat1 = String::concat;
        BiFunction<String, String, String> concat2 = ((s4, s21) -> s4.concat(s21));

        System.out.println(concat1.apply("liara ", "t'soni"));
        System.out.println(concat2.apply("liara ", "t'soni"));

        BinaryOperator<String> concat3 = String::concat;
        BinaryOperator<String> concat4 = (string1, string2) -> string1.concat(string2);

        System.out.println(concat3.apply("liara ", "t'soni"));
        System.out.println(concat4.apply("liara ", "t'soni"));



        // Streamn
        Stream<Double> db = Stream.generate(Math::random);
        Stream<String> ss = Stream.generate(() -> "test");
        Stream<Integer> si = Stream.generate(() -> 1);
        Stream<Object> si2 = Stream.generate(Object::new);


        System.out.println("\n\n");

        String[] words = {"one", "last", "beer", "before", "the", "end", "of", "the", "world"};
        Arrays.stream(words).filter(wordSize -> wordSize.length() > 3).forEach(System.out::println);

        System.out.println("\n\n");


        Arrays.stream(words).map(String::toUpperCase).forEach(System.out::println);

        Stream<Character> schar = Arrays.stream(words).map(fletter -> fletter.charAt(0));
        schar.forEach(System.out::println);


        Stream<Double> sDlbRand = Stream.generate(Math::random).peek(e -> System.out.println(e + " randomly picked")).limit(10);
//        Stream<Double> sDlbRand = Stream.generate(Math::random).limit(10).peek(e -> System.out.println(e + " randomly picked"));
        sDlbRand.forEach(System.out::println);


        Optional<String> beer = Arrays.stream(words).filter(sBeer -> sBeer.startsWith("beer")).findFirst();
        System.out.println(beer);

        Optional<String> the = Arrays.stream(words).filter(sBeer -> sBeer.startsWith("the")).findAny();
        System.out.println(the);

        long nbThe = Arrays.stream(words).filter(sBeer -> sBeer.startsWith("the")).count();
        System.out.println(nbThe);


        // TODO flatmap, reduce, collect


    }
}
