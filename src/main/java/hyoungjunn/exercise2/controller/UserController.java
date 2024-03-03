package hyoungjunn.exercise2.controller;

import hyoungjunn.exercise2.dto.request.UserSaveRequest;
import hyoungjunn.exercise2.dto.request.UserUpdateRequest;
import hyoungjunn.exercise2.dto.response.UserResponse;
import hyoungjunn.exercise2.service.user.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserSaveRequest request) {
       userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
        return userService.getUser();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) { // 파라미터가 한 개일 때는 @RequestParam 을 꼭 써주자
        userService.deleteUser(name);
    }

}
