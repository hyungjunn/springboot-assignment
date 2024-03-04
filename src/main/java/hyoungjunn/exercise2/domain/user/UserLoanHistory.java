package hyoungjunn.exercise2.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private long userId;

    @Column(nullable = false)
    private String bookName;

    private boolean isReturn;

    protected UserLoanHistory() {
    }

    public UserLoanHistory(long userId, String bookName, boolean isReturn) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

}
