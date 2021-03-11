package services;

import entities.Book;
import repositories.interfaces.IBookRepository;
import services.interfaces.IBookService;

import javax.inject.Inject;
import java.util.List;

public class BookService implements IBookService {
    @Inject
    private IBookRepository bookRepository;

    @Override
    public boolean create(Book book) {
        return bookRepository.create(book);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        return books;
    }
    @Override
    public List<Book> getAllBooksByGender(int gender) {
        List<Book> books = bookRepository.getAllBooksByGender(gender);
        return books;
    }
    @Override
    public List<Book> getAllBooksByYear(int year) {
        List<Book> books = bookRepository.getAllBooksByYear(year);
        return books;
    }
    @Override
    public List<Book> getBookByName(String name) {
        List<Book> books = bookRepository.getBookByName(name);
        return books;
    }
    public List<Book> getBookByPublisher(String publisher) {
        List<Book> books = bookRepository.getBookByPublisher(publisher);
        return books;
    }
    @Override
    public List<Book> getBookByPrice(int price) {
        List<Book> books = bookRepository.getBookByPrice(price);
        return books;
    }
    @Override
    public List<Book> getBookByJenre(String jenre) {
        List<Book> books = bookRepository.getBookByJenre(jenre);
        return books;
    }
    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }
}