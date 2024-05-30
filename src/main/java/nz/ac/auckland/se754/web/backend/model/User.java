package nz.ac.auckland.se754.web.backend.model;

import nz.ac.auckland.exception.NoUserFoundException;
import nz.ac.auckland.exception.PrivateProgressException;
import nz.ac.auckland.manager.LearningProgressManager;

import java.util.ArrayList;

public class User {
    LearningProgress learningProgress;
    String username;
    Course[] courses;

    public User(String username){
        this.username = username;
        LearningProgressManager.startLearningProgress(this.username);
        try {
            learningProgress = LearningProgressManager.getLearningProgress(this.username);
        } catch (NoUserFoundException | PrivateProgressException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCourses(Course[] courses){
        this.courses = courses;
    }

    public LearningProgress getLearningProgress(){
        return  learningProgress;
    }

    public ArrayList<CourseTags> getCourseTags(){
        ArrayList<CourseTags> interestedCourses = new ArrayList<CourseTags>();
        if (courses != null) {
            for (Course course : courses) {
                CourseTags courseTags = course.getTagsForCourse();
                if (courseTags.isInterested) {
                    interestedCourses.add(courseTags);
                }
            }
        }
        return interestedCourses;
    }

    public ArrayList<CourseTags> getInProgressCourses(){
        ArrayList<CourseTags> inProgressCourses = new ArrayList<CourseTags>();
        if (courses != null) {
            for (Course course : courses) {
                CourseTags courseTags = course.getTagsForCourse();
                if (courseTags.getProgress().equals("In Progress") || courseTags.getProgress().equals("Completed")) {
                    inProgressCourses.add(courseTags);
                }
            }
        }
        return inProgressCourses;
    }
}
