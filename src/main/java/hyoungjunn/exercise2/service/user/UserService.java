package hyoungjunn.exercise2.service.user;

import hyoungjunn.exercise2.dto.request.UserUpdateRequest;
import hyoungjunn.exercise2.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
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

}
