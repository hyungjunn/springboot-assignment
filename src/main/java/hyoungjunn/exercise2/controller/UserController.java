package hyoungjunn.exercise2.controller;

import hyoungjunn.exercise2.domain.User;
import hyoungjunn.exercise2.dto.request.UserSaveRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody UserSaveRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }

}
