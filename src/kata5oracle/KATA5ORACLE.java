package kata5oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5ORACLE {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
        Statement state = connect.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");

        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));
        }

        rs.close();
        state.close();
        connect.close();
    }
}
