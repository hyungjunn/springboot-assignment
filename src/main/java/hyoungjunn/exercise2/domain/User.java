package hyoungjunn.exercise2.domain;

public class User {

    private String name;
    private Integer age; // null 허용하기 위해 Integer로

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
