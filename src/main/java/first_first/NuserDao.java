package first_first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NuserDao extends UserDAO{
    private String url = "jdbc:mysql://localhost:3306/toby?serverTimezone=UTC";
    private String id = "root";
    private String pw = "1234";

    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, id, pw);
        return c;
    }
}
