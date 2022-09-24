/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author ramir
 */

import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

public class DatabasaConnection {
    protected String url="jdbc:mysql://localhost:3306/biblioteca";//url de MySQL
    private final String usuario="root";
    private final String clave="MySQLServer_Rouss154!";
    Connection conn=null;  
    public Connection conectar(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }         
        return conn;        
    }
    
}
