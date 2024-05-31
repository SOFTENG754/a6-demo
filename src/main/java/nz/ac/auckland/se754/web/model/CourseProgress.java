package nz.ac.auckland.se754.web.model;

import nz.ac.auckland.se754.web.backend.exception.InvalidCourseProgressException;
import nz.ac.auckland.se754.web.backend.exception.NoLessonException;
import nz.ac.auckland.se754.web.backend.model.Course;

public class CourseProgress {
    User user;
    String username;
    Course course;
    CourseItem courseItem;
    int progress;
    public CourseProgress(User user, CourseItem courseItem){
        this.user = user;
        this.courseItem = courseItem;
        this.course = courseItem.getCourse();
    }

    public void startProgress() throws NoLessonException {
        if(course.getLessons().length == 0){
            throw new NoLessonException();
        }
        progress = 0;
    }

    public CourseItem getCourseItem(){return courseItem;};
    public int getProgress(){return progress;}

    public void updateProgress() throws InvalidCourseProgressException {
        if (progress < course.getLessons().length) {
            progress++;
//            user.getLearningProgress().updateNumberOfCompletedLessons();
//            if(course.getLessons().length == progress){
//                user.getLearningProgress().updateNumberOfCompletedCourse();
//            }
        } else{
            throw new InvalidCourseProgressException();
        }
    }
    public int getProgressPercentage(){
        int totalNumberOfLesson = course.getLessons().length;
        return (int)Math.round((double)progress/totalNumberOfLesson * 100);
    }
}
