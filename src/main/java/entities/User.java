package entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User() {

    }

    public User(String name, String surname, String username, String password) {
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    public User(int id, String name, String surname, String username, String password) {
        this(name, surname, username, password);
        setId(id);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}