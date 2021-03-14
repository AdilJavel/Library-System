package repositories.interfaces;

import entities.Author;
import entities.Book;
import entities.Publisher;

import java.util.List;


public interface IAuthorRepository {
    Author getAuthorById(int id);
    boolean create(Author author);
    List<Book> getAuthorBook(String name);
    List<Author> getAllAuthors();
}