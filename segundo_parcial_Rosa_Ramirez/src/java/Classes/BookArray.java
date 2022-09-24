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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookArray {
    Book[] bookTable;
    int indexArray;
    
    private DatabasaConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public BookArray(){
        bookTable = new Book[100];
        this.indexArray = 0;
    }
    
    public void openConnection(){
        connectDB= new DatabasaConnection();
        connection=connectDB.conectar();
    }
    
    public String saveBook(Book book){        
        String sql = "INSERT INTO biblioteca.libro(codigo, nombre_libro, tipo_de_pasta, editorial, anio_publicacion)  ";
             sql += " VALUES(  ?,?,?,?,?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql); 
            statement.setInt(1, book.getCodeBook());
            statement.setString(2, book.getNameBook());
            statement.setString(3, book.getTapeBook());
            statement.setString(4, book.getEditorialBook());
            statement.setString(5, book.getDateBook());
            int resultado = statement.executeUpdate(); 
            
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){
            return e.getMessage();
        }    
    }
    public void getBook(StringBuffer respuesta){   
        String sql="select * from biblioteca.libro";
        try{
        openConnection();
        respuesta.setLength(0);
                
        statement= connection.prepareStatement(sql);                        
        resultSet = statement.executeQuery();            
            if (resultSet!=null){
                while (resultSet.next()){
                respuesta.append("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n" +
                     "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                     +"<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>"
                     +"<script src='js/script.js'></script>"
                     );
                respuesta.append("<tr>");
                respuesta.append("<td >").append(resultSet.getString("codigo")).append("</td>");
                respuesta.append("<td >").append(resultSet.getString("nombre_libro")).append("</td>");
                respuesta.append("<td >").append(resultSet.getString("tipo_de_pasta")).append("</td>");
                respuesta.append("<td >").append(resultSet.getString("editorial")).append("</td>");
                respuesta.append("<td >").append(resultSet.getString("anio_publicacion")).append("</td>");
                respuesta.append("<td id=\"").append(resultSet.getString("codigo"))
                        .append("\"  onclick=\"deleteBook(this.id);\">") 
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
        public String deleteBook(int code){
        String sql = "DELETE FROM libro WHERE codigo = "+code;
        try{
            openConnection();
            statement = connection.prepareStatement(sql);
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){
                    return e.getMessage();
                    }
    }
}
