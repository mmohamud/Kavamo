package mytips.model;

import java.util.List;
import java.util.Date;

public interface ReadingTip {
    public void setId(int id);
    public int getId();
    public void setTitle(String title);
    public String getTitle();
    public void setReadingDate(Date date);
    public Date getReadingStatus();
    public void setDescription(String description);
    public String getDescription();
    public void setRelatedCourses(List<String> course);
    public List<String> getRelatedCourses();
}