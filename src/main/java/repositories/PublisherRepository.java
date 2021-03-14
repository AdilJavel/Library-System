package repositories;

import data.interfaces.IDB;
import entities.Author;
import entities.Book;
import entities.Publisher;
import repositories.interfaces.IPublisherRepository;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PublisherRepository implements IPublisherRepository {
    @Inject
    private IDB db;

    @Override
    public List<Publisher> getAllPublishers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM publishers";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Publisher> publishers = new LinkedList<>();
            while (rs.next()) {
                Publisher publisher =
                        new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                );
                publishers.add(publisher);
            }

            return publishers;
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
    public Publisher getPublisherById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM publishers WHERE publisher_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Publisher publisher = new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("publisher_description")
                );

                return publisher;
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
    public boolean create(Publisher publisher) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO publishers(publisher_name,publisher_description) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, publisher.getName());
            st.setString(2, publisher.getDescription());

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


}