package hyoungjunn.exercise2.service.user;

import hyoungjunn.exercise2.domain.User;
import hyoungjunn.exercise2.domain.UserRepository;
import hyoungjunn.exercise2.dto.request.UserSaveRequest;
import hyoungjunn.exercise2.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserSaveRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

}
