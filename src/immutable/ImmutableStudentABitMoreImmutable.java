// Copyright (c) 2018 Travelex Ltd

package immutable;

public class ImmutableStudentABitMoreImmutable {

    private final int id;
    private final String name;
    private final Age age;


    public ImmutableStudentABitMoreImmutable(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }
}
