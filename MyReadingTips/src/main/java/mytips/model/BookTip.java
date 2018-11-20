/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.util.ArrayList;

/**
 *
 * @author mmohamud
 */
public class BookTip {
    private String Author;
    private String Name;
    private String ISBN;
    private String summary;
    private ArrayList<String> tags;
    private ArrayList<String> preliminaryKnowldge;
    private ArrayList<String> relatedCourses;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    

    public ArrayList<String> getTags() {
        return tags;
    }
    
    public void addTag(String tag) {
        this.tags.add(tag);
    }
    
    public ArrayList<String> getPreliminaryKnowldge() {
        return preliminaryKnowldge;
    }
    
   public void addPreliminaryKnowledge(String knowledge) {
       this.preliminaryKnowldge.add(knowledge);
   }

    public ArrayList<String> getRelatedCourses() {
        return relatedCourses;
    }
   
   public void addRelatedCourse(String courseName) {
       this.relatedCourses.add(courseName);
   }
   
}
