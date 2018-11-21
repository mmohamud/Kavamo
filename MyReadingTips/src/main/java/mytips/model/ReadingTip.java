package mytips.model;

// import java.util.List;
// import java.util.Date;

public interface ReadingTip {
    void setId(int id);
    int getId();
    void setTitle(String title);
    String getTitle();
    void setSummary(String description);
    String getSummary();
    // public void setReadingDate(Date date);
    // public Date getReadingDate();
    // public void setRelatedCourses(List<String> course);
    // public List<String> getRelatedCourses();
}