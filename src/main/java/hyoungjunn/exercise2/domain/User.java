package hyoungjunn.exercise2.domain;

public class User {

    private String name;
    private Integer age; // null 허용하기 위해 Integer로

    public User(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
