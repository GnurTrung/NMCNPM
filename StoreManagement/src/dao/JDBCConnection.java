package src.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {
    public static Connection getConnection() throws SQLException{
        //need dataBase name
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=";
        final String Employee = "";
        final String pass = "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url, Employee, pass);

            return DriverManager.getConnection(url,Employee,pass);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
