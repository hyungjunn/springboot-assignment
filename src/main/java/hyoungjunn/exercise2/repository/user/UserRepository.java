package hyoungjunn.exercise2.repository.user;

import hyoungjunn.exercise2.dto.request.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateUser(UserUpdateRequest request) {
        String sql = "UPDATE user SET name = ? where id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    public boolean isUserNotExist(UserUpdateRequest request) {
        String readSql = "select * from user where id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
    }

    public boolean isUserNotExist(String name) {
        String readSql = "select * from user where name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void deleteUser(String name) {
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }


}
