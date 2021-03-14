import data.PostgresDB;
import data.interfaces.IDB;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import repositories.UserRepository;
import repositories.BookRepository;
import repositories.PublisherRepository;
import repositories.AuthorRepository;
import repositories.interfaces.IAuthorRepository;
import repositories.interfaces.IPublisherRepository;
import repositories.interfaces.IBookRepository;
import repositories.interfaces.IUserRepository;
import services.UserService;
import services.BookService;
import services.PublisherService;
import services.AuthorService;
import services.interfaces.IUserService;
import services.interfaces.IAuthorService;
import services.interfaces.IPublisherService;
import services.interfaces.IBookService;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(PostgresDB.class).to(IDB.class);
        bind(UserRepository.class).to(IUserRepository.class);
        bind(BookRepository.class).to(IBookRepository.class);
        bind(PublisherRepository.class).to(IPublisherRepository.class);
        bind(AuthorRepository.class).to(IAuthorRepository.class);
        bind(AuthorService.class).to(IAuthorService.class);
        bind(UserService.class).to(IUserService.class);
        bind(PublisherService.class).to(IPublisherService.class);
        bind(BookService.class).to(IBookService.class);

    }
}