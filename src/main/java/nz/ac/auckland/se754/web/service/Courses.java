package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.auckland.se754.web.backend.exception.InvalidCourseProgressException;
import nz.ac.auckland.se754.web.backend.exception.NoLessonException;
import nz.ac.auckland.se754.web.backend.model.Course;
import nz.ac.auckland.se754.web.backend.model.Lesson;
import nz.ac.auckland.se754.web.backend.model.Task;
import nz.ac.auckland.se754.web.backend.model.User;
import nz.ac.auckland.se754.web.model.CourseItem;
import nz.ac.auckland.se754.web.model.CourseProgress;
import nz.ac.auckland.se754.web.model.Item;
import org.springframework.stereotype.Service;

@Service
public class Courses {
    private final List<CourseItem> items;
    private final Map<String,List<CourseItem>> courses2user;
    private final Map<String, List<CourseProgress>> user2courseProgress;

    public Courses() throws InvalidCourseProgressException, NoLessonException {
        items = new ArrayList<>();
        courses2user = new HashMap<>();
        user2courseProgress = new HashMap<>();
        Course course1 = new Course(new Lesson[]{new Lesson(), new Lesson()});
        Course course2 = new Course(new Lesson[]{new Lesson(), new Lesson()});
        Course course3 = new Course(new Lesson[]{new Lesson(), new Lesson(), new Lesson()});
        Course course4 = new Course(new Lesson[]{new Lesson(), new Lesson(), new Lesson(), new Lesson()});
        Course course5 = new Course(new Lesson[]{new Lesson(), new Lesson(), new Lesson() ,new Lesson() ,new Lesson()});

        CourseItem courseItem1 = new CourseItem(1, "Course1", course1, "", "Not Started");
        CourseItem courseItem2 =new CourseItem(2, "Course2", course2, "", "Not Started");
        CourseItem courseItem3 =new CourseItem(3, "Course3", course3, "Interested", "Not Started");
        CourseItem courseItem4 =new CourseItem(4, "Course4", course4, "", "In Progress");
        CourseItem courseItem5 = new CourseItem(5, "Course5", course5, "Interested", "Completed");

        items.add(courseItem1);
        items.add(courseItem2);
        items.add(courseItem3);
        items.add(courseItem4);
        items.add(courseItem5);

        User newUser = new User("newUser");
        User returnUser = new User("returnUser");
        courses2user.put(newUser.username, Arrays.asList(items.get(0), items.get(1)));
        courses2user.put(returnUser.username, Arrays.asList(items.get(2), items.get(3), items.get(4)));

        CourseProgress newCourseProgress1 = new CourseProgress(newUser, courseItem1);
        CourseProgress newCourseProgress2 = new CourseProgress(newUser, courseItem2);
        CourseProgress newCourseProgress3 = new CourseProgress(newUser, courseItem3);
        CourseProgress newCourseProgress4 = new CourseProgress(newUser, courseItem4);
        CourseProgress newCourseProgress5 = new CourseProgress(newUser, courseItem5);

        CourseProgress courseProgress1 = new CourseProgress(returnUser, courseItem1);
        CourseProgress courseProgress2 = new CourseProgress(returnUser, courseItem2);
        CourseProgress courseProgress3 = new CourseProgress(returnUser, courseItem3);
        CourseProgress courseProgress4 = new CourseProgress(returnUser, courseItem4);
        CourseProgress courseProgress5 = new CourseProgress(returnUser, courseItem5);

        List<CourseProgress> newCourseProgresses = new ArrayList<>();
        newCourseProgresses.add(initializeProgress(newCourseProgress1, 0));
        newCourseProgresses.add(initializeProgress(newCourseProgress2, 0));
        newCourseProgresses.add(initializeProgress(newCourseProgress3, 0));
        newCourseProgresses.add(initializeProgress(newCourseProgress4, 0));
        newCourseProgresses.add(initializeProgress(newCourseProgress5, 0));

        List<CourseProgress> returnCourseProgresses = new ArrayList<>();

        returnCourseProgresses.add(initializeProgress(courseProgress1, 0));
        returnCourseProgresses.add(initializeProgress(courseProgress2, 1));
        returnCourseProgresses.add(initializeProgress(courseProgress3, 2));
        returnCourseProgresses.add(initializeProgress(courseProgress4, 3));
        returnCourseProgresses.add(initializeProgress(courseProgress5, 5));

        user2courseProgress.put(newUser.username, newCourseProgresses);
        user2courseProgress.put(returnUser.username, returnCourseProgresses);
    }

    public List<CourseItem> retrieveCourses(String user) {
        List<CourseItem> filteredItems = new ArrayList<>();
        if (courses2user.containsKey(user)) {
            filteredItems.addAll(courses2user.get(user));
        }
        return filteredItems;
    }

    public CourseProgress initializeProgress(CourseProgress courseProgress, int steps) throws NoLessonException, InvalidCourseProgressException {
        courseProgress.startProgress();
        for(int i=steps; i>0; i--){
            courseProgress.updateProgress();
        }
        return courseProgress;
    }

    public void toggleInterest(int id) {
        CourseItem courseItem = items.get(id-1);
        if (courseItem.getInterest().equals("Interested")) {
            courseItem.setInterest("");
            return;
        }
        courseItem.setInterest("Interested");
    }

    public CourseProgress retrieveUserProgress(String username, int courseNumber){
        if(user2courseProgress.containsKey(username)){
            List<CourseProgress> filteredItems = new ArrayList<>(user2courseProgress.get(username));
            for (CourseProgress courseProgress: filteredItems
                 ) {
                if(courseProgress.getCourseItem().getId() == courseNumber){
                    return courseProgress;
                }
            }
        }
        return null;
    }
}