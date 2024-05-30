package nz.ac.auckland.se754.web.backend.model;

public class Course {
    private Lesson[] lessons;
    private CourseTags CourseTags;

    public Course(Lesson[] lessons){
        this.lessons = lessons;
        this.CourseTags = new CourseTags(this);
    }

    public Lesson[] getLessons(){
        return lessons;
    }

    public CourseTags getTagsForCourse(){
        return CourseTags;
    }

    public void setInterested(boolean isInterested){
        CourseTags.setInterested(isInterested);
    }
}
