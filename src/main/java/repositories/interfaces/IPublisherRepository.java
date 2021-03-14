package repositories.interfaces;

import entities.Book;
import entities.Publisher;

import java.util.List;


public interface IPublisherRepository {
    Publisher getPublisherById(int id);
    boolean create(Publisher publisher);
    List<Publisher> getAllPublishers();
}