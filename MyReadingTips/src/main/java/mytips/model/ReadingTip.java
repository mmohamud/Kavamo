package mytips.model;

import java.util.List;
import java.util.Date;

public interface ReadingTip {
    public void setId(int id);
    public int getId();
    public void setTitle(String title);
    public String getTitle();
    public void setSummary(String description);
    public String getSummary();
    // public void setReadingDate(Date date);
    // public Date getReadingDate();
    // public void setRelatedCourses(List<String> course);
    // public List<String> getRelatedCourses();
}