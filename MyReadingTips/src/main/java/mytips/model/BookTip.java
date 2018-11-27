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

<<<<<<< HEAD
    @Entity
    @Table(name = "BookTip")
    public class BookTip implements ReadingTip {

        @Id @GeneratedValue
        @Column(name = "id")
        private int id;
        
        @Column(name = "author")
        private String author;
        
        @Column(name = "title")
        private String title;
        
        @Column(name = "ISBN")
        private String ISBN;
        
        @Column(name = "summary")
        private String summary;
        
        @Column(name = "comment")
        private String comment;
        
        //private ArrayList<String> tags;
        //private ArrayList<String> prerequisiteCourses;
        //private ArrayList<String> relatedCourses;

        //public BookTip(int id, String author, String title, String ISBN, String summary, String comment) {
          //  this.author = author;
            //this.title = title;
            //this.ISBN = ISBN;
            //this.summary = summary;
            //this.comment = comment;
            //this.tags = tags;
            //this.prerequisiteCourses = prerequisiteCourses;
            //this.relatedCourses = relatedCourses;
        //}

        public BookTip() {
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setName(String name) {
            this.title = name;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSummary() {
            return summary;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getComment() {
            return comment;
        }
=======
    
    public BookTip(int id, String author, String title,
            String summary, String comment) {
        super(id, author, title, summary, comment, "book");
    }
>>>>>>> c7f657861d5e25656e31fb2c83d8c49b260a5d29

    public void print() {
        System.out.println("Kirjan nimi: " + super.getTitle());
        System.out.println("Kirjoittaja: " + super.getAuthor());
        System.out.println("Tiivistelmä: " + super.getSummary());
        System.out.println("Kommentti: " + super.getComment());
    }
}

