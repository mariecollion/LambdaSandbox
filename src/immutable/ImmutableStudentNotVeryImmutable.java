// Copyright (c) 2018 Travelex Ltd

package immutable;

public class ImmutableStudentNotVeryImmutable {

    private final int id;
    private final String name;
    private final Age age;


    public ImmutableStudentNotVeryImmutable(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
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
