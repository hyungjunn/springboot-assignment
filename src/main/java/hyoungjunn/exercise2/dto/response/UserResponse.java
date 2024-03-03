package hyoungjunn.exercise2.dto.response;

import hyoungjunn.exercise2.domain.User;

public class UserResponse {

    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, User user) { // 생성자를 변형 주로 하는 거 조심!!
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
