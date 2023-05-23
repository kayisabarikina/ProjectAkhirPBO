/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class KoneksiTravel {
    static Connection connect;
    
    public static Connection getConnection(){
        if(connect == null) {
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("db_travel");
            db.setUser("root");
            db.setPassword("");
            
            try{
                connect = db.getConnection();
                System.out.println("Connected");
            }catch (SQLException e){
                System.out.println("Error" + e.getMessage());
            }
        }
        return connect;
        
    }
}
