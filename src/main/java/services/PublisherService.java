package services;

import entities.Book;
import entities.Publisher;
import repositories.interfaces.IPublisherRepository;
import services.interfaces.IPublisherService;

import javax.inject.Inject;

public class PublisherService implements IPublisherService {
    @Inject
    private IPublisherRepository publisherRepository;

    @Override
    public boolean create(Publisher publisher) {
        return publisherRepository.create(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.getPublisherById(id);
    }
}