package nz.ac.auckland.se754.web.backend.model;

public class LearningProgress {
    private int numberOfCompletedLesson;
    private int numberOfCompletedCourse;
    private boolean isPrivate;
    public LearningProgress(){
        numberOfCompletedLesson = 0;
        numberOfCompletedCourse = 0;
        isPrivate = false;
    }

    public int getNumberOfCompletedLessons(){
        return numberOfCompletedLesson;
    }

    public void updateNumberOfCompletedLessons(){
        numberOfCompletedLesson++;
    }

    public int getNumberOfCompletedCourses(){
        return numberOfCompletedCourse;
    }

    public void updateNumberOfCompletedCourse(){
        numberOfCompletedCourse++;
    }

    public boolean getIsPrivate(){
        return isPrivate;
    }
    public void setPrivate(boolean val){
        isPrivate = val;
    }
}


