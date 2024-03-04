package hyoungjunn.exercise2.service.book;

import hyoungjunn.exercise2.domain.book.Book;
import hyoungjunn.exercise2.domain.book.BookRepository;
import hyoungjunn.exercise2.domain.user.User;
import hyoungjunn.exercise2.domain.user.UserLoanHistory;
import hyoungjunn.exercise2.domain.user.UserLoanHistoryRepository;
import hyoungjunn.exercise2.domain.user.UserRepository;
import hyoungjunn.exercise2.dto.book.BookLoanRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository, UserLoanHistoryRepository userLoanHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveBook(String name) {
        bookRepository.save(new Book(name));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        //1. 유저를 찾는다
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        //2. 책정보를 찾는다 -> request.getBookName

        // 만약 내가 빌려가려는 책이 이미 다른 사람이 빌렸다면
        // 예외처리
        boolean isExistLoanUser = userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false);
        if (isExistLoanUser) {
            throw new IllegalArgumentException();
        }
        // 요청한 책을 내 이름으로 등록한다
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), request.getBookName(), false));
    }

}
