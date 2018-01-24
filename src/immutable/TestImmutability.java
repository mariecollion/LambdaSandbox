// Copyright (c) 2018 Travelex Ltd

package immutable;

public class TestImmutability {

    public static void main(String[] args){

        Age age = new Age();
        age.setDay(1);
        age.setMonth(7);
        age.setYear(1992);
        ImmutableStudentNotVeryImmutable student = new ImmutableStudentNotVeryImmutable(1, "Shepard", age);

        System.out.println("Shepard age year before modification = " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Shepard age year before modification = " + student.getAge().getYear());

        System.out.println("\n");



        Age age2 = new Age();
        age2.setDay(1);
        age2.setMonth(7);
        age2.setYear(1992);
        ImmutableStudentABitMoreImmutable student2 = new ImmutableStudentABitMoreImmutable(1, "Shepard", age2);

        System.out.println("Shepard age year before modification = " + student2.getAge().getYear());
        age2.setYear(1993);
        System.out.println("Shepard age year before modification = " + student2.getAge().getYear());



        System.out.println("\n");


        Age age3 = new Age();
        age3.setDay(1);
        age3.setMonth(7);
        age3.setYear(1992);
        ImmutableStudentABitMoreImmutable student3 = new ImmutableStudentABitMoreImmutable(1, "Shepard", age3);

        System.out.println("Shepard age year before modification = " + student3.getAge().getYear());
        student3.getAge().setYear(1995);
        System.out.println("Shepard age year before modification = " + student3.getAge().getYear());




        System.out.println("\n");


        Age age4 = new Age();
        age4.setDay(1);
        age4.setMonth(7);
        age4.setYear(1992);
        ImmutableStudent student4 = new ImmutableStudent(1, "Shepard", age4);

        System.out.println("Shepard age year before modification = " + student4.getAge().getYear());
        student4.getAge().setYear(1995);
        System.out.println("Shepard age year before modification = " + student4.getAge().getYear());

    }



}
