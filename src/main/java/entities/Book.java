package entities;

public class Book {
    private int id;
    private String name;
    private int publishYear;
    private String genre;
    private int price;
    private int publisherId;
    private Publisher publisher;
    private int authorId;
    private Author author;

    public Book() {

    }

    public Book(int id, String name, String genre) {
        setId(id);
        setName(name);
        setGenre(genre);
    }

    public Book(String name, int publishYear, String genre, int price, int publisherId, int authorId) {
        setName(name);
        setPublishYear(publishYear);
        setGenre(genre);
        setPrice(price);
        setPublisherId(publisherId);
        setAuthorId(authorId);
    }

    public Book(int id, String name, int publishYear, String genre, int price, int publisherId, int authorId, Publisher publisher, Author author) {
        this(name, publishYear, genre, price, publisherId, authorId);
        setId(id);
        setPublisher(publisher);
        setAuthor(author);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }

    public int getPublishYear() {return publishYear;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public int getAuthorId() { return authorId; }

    public void setAuthorId(int authorId) {this.authorId = authorId; }

    public int getPublisherId() { return publisherId; }

    public void setPublisherId(int publisherId) { this.publisherId = publisherId; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year of publish='" + publishYear + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }

}
