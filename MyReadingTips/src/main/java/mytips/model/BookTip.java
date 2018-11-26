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
public class BookTip implements ReadingTip {
    private int id;
    private String author;    
    private String title;
    private String summary;
    private String comment;
    //private ArrayList<String> tags;
    //private ArrayList<String> prerequisiteCourses;
    //private ArrayList<String> relatedCourses;

    
    public BookTip(int id, String author, String title, String summary, String comment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.comment = comment;
        //this.tags = tags;
        //this.prerequisiteCourses = prerequisiteCourses;
        //this.relatedCourses = relatedCourses;
    }

    public BookTip() {
    }

    public void print() {
        System.out.println("Kirjan nimi: " + this.title);
        System.out.println("Kirjoittaja: " + this.author);
        System.out.println("Tiivistelmä: " + this.summary);
        System.out.println("Kommentti: " + this.comment);
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

//    public ArrayList<String> getTags() {
//        return tags;
//    }
//    
//    public void addTag(String tag) {
//        this.tags.add(tag);
//    }
//    
//    public ArrayList<String> getPrerequisiteCourses() {
//        return prerequisiteCourses;
//    }
//    
//   public void addPreliminaryKnowledge(String knowledge) {
//       this.prerequisiteCourses.add(knowledge);
//   }
//
//    public ArrayList<String> getRelatedCourses() {
//        return relatedCourses;
//    }
//   
//   public void addRelatedCourse(String courseName) {
//       this.relatedCourses.add(courseName);
//   }
}

