package entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private int favBook1;
    private int favBook2;
    private int favBook3;

    public User() {

    }

    public User(int id, String name, String surname) {
        setId(id);
        setName(name);
        setSurname(surname);
    }
    public User(int id, String name, String gender, int favbook1, int favBook2, int favBook3) {
        this(id, name, gender);
        setFavBook1(favbook1);
        setFavBook2(favBook2);
        setFavBook3(favBook3);
    }

    public void setFavBook1(int favBook1) { this.favBook1 = favBook1; }

    public int getFavBook1() { return favBook1; }

    public void setFavBook2(int favBook2) { this.favBook2 = favBook2; }

    public int getFavBook2() { return favBook2; }

    public void setFavBook3(int favBook3) {this.favBook3 = favBook3;}

    public int getFavBook3() {return favBook3; }

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

    public String withFavs() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + name + '\'' +
                ", favourite books id=" + favBook1 + " " + favBook2 + " " + favBook3 +
                '}';
    }

    @Override
    public String toString() {
        return "Author " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '\n';
    }
}