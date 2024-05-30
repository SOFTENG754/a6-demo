package nz.ac.auckland.se754.web.backend.model;

import nz.ac.auckland.exception.InvalidCourseProgressException;
import nz.ac.auckland.exception.NoLessonException;

public class CourseProgress {
    User user;
    Course course;
    int progress;
    public CourseProgress(User user, Course course){
        this.user = user;
        this.course = course;
    }

    public void startProgress() throws NoLessonException {
        if(course.getLessons().length == 0){
            throw new NoLessonException();
        }
        progress = 0;
    }

    public int getProgress(){return progress;}

    public void updateProgress() throws InvalidCourseProgressException {
        if (progress < course.getLessons().length) {
            progress++;
            user.getLearningProgress().updateNumberOfCompletedLessons();
            if(course.getLessons().length == progress){
                user.getLearningProgress().updateNumberOfCompletedCourse();
            }
        } else{
            throw new InvalidCourseProgressException();
        }
    }
    public int getProgressPercentage(){
        int totalNumberOfLesson = course.getLessons().length;
        return (int)Math.round((double)progress/totalNumberOfLesson * 100);
    }
}
