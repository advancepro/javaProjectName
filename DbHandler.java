package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler extends Configs {
    Connection dbconnection;

    public Connection getConnection()
    {
        String connectionString = "jdbc:mysql://"+Configs.dbhost+ ":" + Configs.dbport + "/" + Configs.dbname+"?useTimezone=true&serverTimezone=UTC";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbconnection = DriverManager.getConnection(connectionString,Configs.dbuser,Configs.dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbconnection;
    }
}
