package services;

import entities.Book;
import entities.Publisher;
import repositories.interfaces.IPublisherRepository;
import services.interfaces.IPublisherService;

import javax.inject.Inject;
import java.util.List;

public class PublisherService implements IPublisherService {
    @Inject
    private IPublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.getAllPublishers();
        return publishers;
    }

    @Override
    public boolean create(Publisher publisher) {
        return publisherRepository.create(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.getPublisherById(id);
    }
}