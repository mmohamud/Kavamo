package mytips.model;

// import java.util.List;
import java.util.Date;

public class ReadingTip {
    private String title;
    private String author;
    private String summary;
    private String comment;
    private int id;
    private Date readingDate;
    private String type;
    private String url;
    private String isbn;
    //private ArrayList<String> tags;
    //private ArrayList<String> prerequisiteCourses;
    //private ArrayList<String> relatedCourses;

    public ReadingTip(String author, String title, 
            String summary, String comment, String type) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.comment = comment;
        this.type = type;
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


    public void setReadingDate(Date date) {
        this.readingDate = date;
    }

    public Date getReadingDate() {
        return this.readingDate;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Otsikko: " + title + "\nKirjailija: " + author 
                + "\ntyyppi: " + type + "\nid: " + id;
    }
    
    
    
}