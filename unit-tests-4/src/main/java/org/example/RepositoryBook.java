package org.example;
import java.util.List;

public interface RepositoryBook {
    Book findById(String id);

    List<Book> findAll();
}
