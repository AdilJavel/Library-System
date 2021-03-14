package repositories;

import data.interfaces.IDB;
import entities.Author;
import entities.Book;
import entities.Publisher;
import entities.User;
import repositories.interfaces.IUserRepository;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Inject
    private IDB db;

    @Override
    public boolean removeUserById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM users WHERE id=?";
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
    public List<User> getUsersWithSame(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE favbook1 = ? OR favbook2 = ? OR favbook3 = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, id);
            st.setInt(3, id);
            ResultSet rs = st.executeQuery();
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user= new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("surname")
                );
                users.add(user);
            }

            return users;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user= new User(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("surname")
                );
                users.add(user);
            }

            return users;
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
    public User getUserById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                 User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("surname")
                );

                return user;
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
    public User getUserByIdWithBooks(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("favbook1"),
                        rs.getInt("favbook2"),
                        rs.getInt("favbook3")
                );

                return user;
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
    public boolean create(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name,surname, favbook1, favbook2, favbook3) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setInt(3, user.getFavBook1());
            st.setInt(4, user.getFavBook2());
            st.setInt(5, user.getFavBook3());

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