package game.helpers;

import java.sql.*;

/**
 * Created by pawel on 28/05/14.
 */
public class DatabaseConnector {

    Connection connection = null;

    public DatabaseConnector() {

    }

    public void connect() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memory", "root", "warkamu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {

        if( connection != null ) {
            try {
                connection.close();
                System.out.println("disconnected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public void register(String login, String email, String password) throws SQLException {

        String checkSql = "SELECT COUNT(*) FROM users WHERE login=?";

        PreparedStatement checkStmt = connection.prepareStatement(checkSql);

        checkStmt.setString(1, login);
        ResultSet checkResult = checkStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        if(count == 0) { // we register new user
            System.out.println("inserting user");
        } else {
            System.out.println("can't register user already exists");
        }


        checkStmt.close();


    }

    public void login(String login, String password) throws SQLException {

        String checkSql = "SELECT COUNT(*) FROM users WHERE login=?";

        PreparedStatement checkStmt = connection.prepareStatement(checkSql);

        checkStmt.setString(1, login);
        ResultSet checkResult = checkStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        if(count == 0) { // we register new user
            System.out.println("login user");
        } else {
            System.out.println("can't login user");
        }


        checkStmt.close();
    }
}
