package hyoungjunn.exercise2.service.user;

import hyoungjunn.exercise2.dto.request.UserSaveRequest;
import hyoungjunn.exercise2.dto.request.UserUpdateRequest;
import hyoungjunn.exercise2.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.userRepository = new UserRepository(jdbcTemplate);
    }

    public void updateUser(UserUpdateRequest request) {
        if (userRepository.isUserNotExist(request)) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUser(request);
    }

    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

    public void saveUser(UserSaveRequest request) {
        userRepository.saveUser(request);
    }

}
