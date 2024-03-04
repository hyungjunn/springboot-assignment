package hyoungjunn.exercise2.service.book;

import hyoungjunn.exercise2.domain.book.Book;
import hyoungjunn.exercise2.domain.book.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(String name) {
        bookRepository.save(new Book(name));
    }

}
