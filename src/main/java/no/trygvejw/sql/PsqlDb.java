package no.trygvejw.sql;

import no.ntnu.util.ThrowingConsumer;
import no.trygvejw.debugLogger.DebugLogger;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class PsqlDb {

    private final String url;// = System.getenv("SQLURL");
    private final String dbUser;// = System.getenv("POSGRESS_USER");
    private final String dbPassword;// = System.getenv("POSGRESS_PASSWORD");

    protected static final DebugLogger allQueries = new DebugLogger(false);
    protected static final DebugLogger errorQueries = new DebugLogger(true);

    private int conTries = 1;
    private int waitTime = 5; //seconds

    public PsqlDb(String url, String dbUser, String dbPassword, int conTries, int waitTime) {
        this.url = url;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.conTries = conTries;
        this.waitTime = waitTime;
    }

    private Connection tryConnectToDB(){
        allQueries.log("try connect to db", "url", url, "user", dbUser, "passwd", dbPassword);
        Connection connection = null;
        int tries = 0;

        while (tries < this.conTries){
            try{
                Class.forName("org.postgresql.Driver"); // i think this is to chek if the class exists

                connection = DriverManager.getConnection(url, dbUser, dbPassword);
            } catch (Exception e){
                errorQueries.sLog(e);
                try {
                    Thread.sleep(waitTime * 1000);
                } catch (Exception ignored){}
            }

            tries ++;
        }


        return connection;
    }



    public void sqlQuery(String query, ThrowingConsumer<ResultSet, SQLException> rowHandler){
        try{
            sqlQueryUnCaught(query, rowHandler);
        } catch (SQLException e){
            errorQueries.log("ERROR QUERY:", query);
            errorQueries.sLog(e);
        }
    }

    public void sqlQueryUnCaught(String query, ThrowingConsumer<ResultSet, SQLException> rowHandler) throws SQLException{

        Connection connection = this.tryConnectToDB();
        Statement statement = connection.createStatement();

        allQueries.log("making SQL query:\n", query);
        ResultSet resultSet = statement.executeQuery(query);


        while (resultSet.next()){
            rowHandler.accept(resultSet);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }



    public void sqlUpdate(String query){
        try{
            sqlUpdateUnCaught(query);
        } catch (SQLException e){
            errorQueries.log("ERROR QUERY:", query);
            e.printStackTrace();
        }
    }

    public void sqlUpdateUnCaught(String query) throws SQLException{
        Connection connection = tryConnectToDB();
        Statement statement = connection.createStatement();

        allQueries.log("making SQL update:\n", query);
        statement.executeUpdate(query);


        statement.close();
        connection.close();

    }
}
