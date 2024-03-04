package hyoungjunn.exercise2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // find라고 입력하면 1개의 데이터만 가져오기 때문에 반환타입을 User로 한다.
    // 더 깔끔하게 하기 위해 Optional을 쓴다
    Optional<User> findByName(String name);

}
