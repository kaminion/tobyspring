package first_first;

import java.sql.*;

public abstract class UserDAO {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("INSERT INTO USERS(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException
    {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("SELECT * FROM USERS WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public boolean delete(String id) throws ClassNotFoundException, SQLException
    {
        boolean flag = false;
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE id = ?");
        ps.setString(1, id);

        if(ps.executeUpdate() > 0)
        {
            flag = true;
        }

        return flag;
    }

    // DB연결에대해 더 유연성을 가짐
    protected abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
