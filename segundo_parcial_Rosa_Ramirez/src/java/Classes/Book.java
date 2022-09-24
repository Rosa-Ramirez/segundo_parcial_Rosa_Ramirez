/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author ramir
 */
public class Book {
    private int codeBook;
    private String nameBook;
    private String tapeBook;
    private String editorialBook;
    private String dateBook;

         public Book(int codeBook, String nameBook, String tapeBook, String editorialBook, String dateBook){
                    this.codeBook = codeBook;
                    this.nameBook = nameBook;
                    this.tapeBook = tapeBook;
                    this.editorialBook = editorialBook;
                    this.dateBook = dateBook;
         };

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getTapeBook() {
        return tapeBook;
    }

    public void setTapeBook(String tapeBook) {
        this.tapeBook = tapeBook;
    }

    public String getEditorialBook() {
        return editorialBook;
    }

    public void setEditorialBook(String editorialBook) {
        this.editorialBook = editorialBook;
    }

    public String getDateBook() {
        return dateBook;
    }

    public void setDateBook(String dateBook) {
        this.dateBook = dateBook;
    }
         
         
}

