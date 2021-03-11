package entities;

public class Author {
    private int id;
    private String name;
    private String gender;
    private Book book;

    public Author() {

    }

    public Author(int id, String name, String gender) {
        setId(id);
        setName(name);
        setGender(gender);
    }
    public Author(int id, String name, String gender, Book book) {
        this(id, name, gender);
        setBook(book);
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}