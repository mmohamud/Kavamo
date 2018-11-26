/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

/**
 *
 * @author mmohamud
 */
public class WebTip {
    private String title;
    private String author;
    private String type;
    private String summary;

    public String getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    
    
}
