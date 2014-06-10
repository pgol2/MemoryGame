package game.helpers;

import java.sql.*;
import java.util.ArrayList;

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



    public boolean registerToDB(String login, String email, String password) throws SQLException {

        boolean success = false;
        String checkSql = "SELECT COUNT(*) FROM users WHERE login=?";

        PreparedStatement checkStmt = connection.prepareStatement(checkSql);

        checkStmt.setString(1, login);
        ResultSet checkResult = checkStmt.executeQuery(); // TODO check here is the insert was successcus
        //TODO prompt user if insert was succesfull


        checkResult.next();
        int count = checkResult.getInt(1);

        if(count == 0) { // we register new user
            System.out.println("inserting user");
            System.out.println(login + " " + email + " " + password);

            String insertSql = "INSERT INTO users (login, mail,password) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSql);

            insertStmt.setString(1, login);
            insertStmt.setString(2, email);
            insertStmt.setString(3, password);

            insertStmt.executeUpdate();

            insertStmt.close();
            success = true;
        } else {
            System.out.println("can't register user already exists");
            success = false;

        }

        checkStmt.close();

        return success;
    }

    public boolean loginToDB(String login, String password) throws SQLException {

        String checkSql = "SELECT COUNT(*) FROM users WHERE login=? AND password=?";

        PreparedStatement checkStmt = connection.prepareStatement(checkSql);

        checkStmt.setString(1, login);
        checkStmt.setString(2, password);
        ResultSet checkResult = checkStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        boolean retValue = false;
        if(count == 0) { // can't login
            System.out.println("can't login");
        } else {
            System.out.println("login user");
            retValue = true;
        }


        checkStmt.close();
        return retValue;
    }

    public boolean insertScore(String user, double score) throws SQLException {

        boolean inserted = false;

        String insertScoreSql = "INSERT INTO scores (login, score) VALUES (?, ?)";

        PreparedStatement insertScoreStmt = connection.prepareStatement(insertScoreSql);
        insertScoreStmt.setString(1, user);
        insertScoreStmt.setDouble(2, score);

        insertScoreStmt.executeUpdate();


        return inserted;
    }


    public ArrayList<String> getUserScores(String user) throws SQLException {
        //TODO debug this code !
        ArrayList<String> scores = new ArrayList<String>();

        boolean found = false;
        String getSql = "SELECT score FROM scores WHERE login = '?'";

        PreparedStatement checkStmt = connection.prepareStatement(getSql);

        checkStmt.setString(1, user);
        ResultSet result = checkStmt.executeQuery();
        String scoreVal = "";
        String score = "";

        while (result.next()) {
            scoreVal = result.getString(0);
            score = user + " " + scoreVal;
            scores.add(score);
        }

        for(String sc: scores) {
            System.out.println(sc + "scoreee !");
        }
        return scores;

    }
}
