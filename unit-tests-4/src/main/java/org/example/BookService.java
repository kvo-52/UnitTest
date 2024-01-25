package org.example;

import java.util.List;
public class BookService {
    private RepositoryBook bookRepository;

    public BookService(RepositoryBook bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
