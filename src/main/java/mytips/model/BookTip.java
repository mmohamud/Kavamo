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
            String summary, String comment, String isbn) {
        super(id, author, title, summary, comment);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return "\nKirjoittaja: " + getAuthor()
                + "\nOtsikko: " + getTitle()
                + "\nISBN: " + getIsbn()
                + "\nKuvaus: " + getSummary()
                + "\nKommentti: " + getComment()
                ;
    }
}

