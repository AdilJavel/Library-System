package services.interfaces;

import entities.Author;
import entities.Book;

import java.util.List;

public interface IAuthorService {
    Author getAuthorById(int id);
    boolean create(Author author);
    List<Author> getAuthorBook();
}