package database;

import com.oanda.v20.instrument.Candlestick;

import java.sql.*;
import java.util.List;

public class DatabaseStorage {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private static class SingletonHolder {
       private static final DatabaseStorage HOLDER_INSTANCE = new DatabaseStorage();
    }

    public static DatabaseStorage getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exchange_analyzer");
        statement = connection.createStatement();
    }

    public void storeCandles(List<Candlestick> candlestickList){
        String query = "INSERT INTO CANDLESTICKS () values ();";
    }
}