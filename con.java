package Hotel.Management.System;

import java.sql.Connection;
import javax.swing.plaf.nimbus.State;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Stack;

public class con {
    Connection connection;
    Statement statement;

    public con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "mypassword");
            statement = connection.createStatement();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
