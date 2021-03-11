package services.interfaces;

import entities.Book;
import entities.Publisher;

public interface IPublisherService {
    Publisher getPublisherById(int id);
    boolean create(Publisher publisher);
}