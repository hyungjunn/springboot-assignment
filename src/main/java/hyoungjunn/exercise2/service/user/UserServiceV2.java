package hyoungjunn.exercise2.service.user;

import hyoungjunn.exercise2.domain.user.User;
import hyoungjunn.exercise2.domain.user.UserRepository;
import hyoungjunn.exercise2.dto.user.request.UserSaveRequest;
import hyoungjunn.exercise2.dto.user.request.UserUpdateRequest;
import hyoungjunn.exercise2.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserSaveRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional
    public List<UserResponse> getUser() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        //영속성 컨텍스트가 실행되면서 변경을 감지(Dirty check)되어 알아서 저장하기
        //때문에 아래의 save메서드가 필요가 없어지게 된다
        //userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }

}
