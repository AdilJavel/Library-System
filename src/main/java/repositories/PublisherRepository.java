package repositories;

import data.interfaces.IDB;
import entities.Author;
import entities.Publisher;
import repositories.interfaces.IPublisherRepository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherRepository implements IPublisherRepository {
    @Inject
    private IDB db;


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