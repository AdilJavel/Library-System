package services.interfaces;

import entities.Book;
import entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher getPublisherById(int id);
    boolean create(Publisher publisher);
    List<Publisher> getAllPublishers();
}