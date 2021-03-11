package repositories.interfaces;

import entities.Book;

import java.util.List;


public interface IBookRepository {
    Book getBookById(int id);
    boolean create(Book book);
    List<Book> getAllBooks();
    List<Book> getAllBooksByGender(int gender);
    List<Book> getAllBooksByYear(int year);
    List<Book> getBookByName(String name);
    List<Book> getBookByJenre(String jenre);
    List<Book> getBookByPrice(int price);
    List<Book> getBookByPublisher(String publisher);
}