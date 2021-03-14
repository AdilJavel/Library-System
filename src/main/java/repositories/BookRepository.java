package repositories;

import data.interfaces.IDB;
import entities.Publisher;
import entities.Author;
import entities.Book;
import repositories.interfaces.IBookRepository;

import javax.inject.Inject;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class BookRepository implements IBookRepository {
    @Inject
    private IDB db;

    @Override
    public List<Book> getAllBooks() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean create(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO books(name,publishyear,genre,price,publisherid,authorid) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, book.getName());
            st.setInt(2, book.getPublishYear());
            st.setString(3, book.getGenre());
            st.setInt(4, book.getPrice());
            st.setInt(5,book.getPublisherId());
            st.setInt(6, book.getAuthorId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Book getBookById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND b.id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean removeBookById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            if(st.execute())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Book> getAllBooksByGender(int gender) {
        String gendera;
        if (gender==1) {
            gendera = "Male";
        } else {
            gendera = "Female";
        }
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND a.author_gender=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, gendera);
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Book> getAllBooksByYear(int year) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND b.publishyear>?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Book> getBookByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND b.name LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Book> getBookByJenre(String jenre) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND b.genre LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + jenre + "%");
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Book> getBookByPrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql;
            sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND b.price > ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, price);
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Book> getBookByPublisher(String publisher) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books b, authors a, publishers p WHERE b.publisherid=p.publisher_id AND b.authorid=a.author_id AND p.publisher_name LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + publisher + "%");
            ResultSet rs = st.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("publishYear"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getInt("publisherid"),
                        rs.getInt("authorid"),
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                        ),
                        new Author(
                                rs.getInt("author_id"),
                                rs.getString("author_name"),
                                rs.getString("author_gender")
                        )

                );
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}