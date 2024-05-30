package nz.ac.auckland.se754.web.backend.model;

public class CourseTags {
    public Course course;
    public boolean isInterested;

    public CourseTags(Course course) {
        this.course = course;
    }
    public void setInterested(boolean isInterested){
        this.isInterested = isInterested;
    }

    public String getProgress(){
        Lesson[] lessons = course.getLessons();
        int totalLessons = lessons.length;
        int completedLessons = 0;
        for (Lesson lesson : lessons) {
            if (lesson.isCompleted()) {
                completedLessons++;
            }
        }
        double progress = (double) (completedLessons * 100) / totalLessons;
        if (progress == 100){
            return "Completed";
        } else if (progress > 0) {
            return "In Progress";
        } else {
            return "Not Started";
        }
    }
}