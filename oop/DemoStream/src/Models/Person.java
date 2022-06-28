package Models;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        System.out.println("A Person was instantiated.");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        // For an object to be equal it must be a non-null Person with the same name and age
        if(object == null) {
            return false;
        }
        if(object instanceof Person) {
            return ((Person)object).getName().equals(this.getName()) && ((Person)object).getAge() == this.getAge();
        }
        return false;
    }

    @Override
    public int compareTo(Person person) {
        if( person == null ) {
            return 1; // if Person is null, this is higher (positive value)
        }
        return this.getAge() - person.getAge(); // this is higher if its age is higher
    }
}
