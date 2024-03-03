package hyoungjunn.exercise2.controller;

import hyoungjunn.exercise2.domain.User;
import hyoungjunn.exercise2.dto.request.UserSaveRequest;
import hyoungjunn.exercise2.dto.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody UserSaveRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            responses.add(new UserResponse(i + 1, users.get(i)));
        }
        return responses;
    }

}
