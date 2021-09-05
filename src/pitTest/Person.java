package pitTest;

public class Person {

    private String name;
    private String surname;
    private Role role;
    private int age;

    public Person(String name, String surname, Role role, int age) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "pitTest.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                ", age=" + age +
                '}';
    }
}
