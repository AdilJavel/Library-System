package repositories.interfaces;

import entities.Book;
import entities.Publisher;


public interface IPublisherRepository {
    Publisher getPublisherById(int id);
    boolean create(Publisher publisher);
}