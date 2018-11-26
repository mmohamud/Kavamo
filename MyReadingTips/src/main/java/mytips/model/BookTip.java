/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

//import java.util.ArrayList;
import javax.persistence.*;
//import javax.persistence.Entity;

/**
 *
 * @author mmohamud
 */

@Entity
@Table(name = "BookTip")
public class BookTip extends ReadingTip {
    private String isbn;

    
    public BookTip(int id, String author, String title, 
                String isbn, String summary, String comment) {
        super(id, author, title, summary, comment, "book");
        this.isbn = isbn;
    }

    public void print() {
        System.out.println("Kirjan nimi: " + super.getTitle());
        System.out.println("Kirjoittaja: " + super.getAuthor());
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Tiivistelmä: " + super.getSummary());
        System.out.println("Kommentti: " + super.getComment());
    }
    
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public String getISBN() {
        return isbn;
    }
}

