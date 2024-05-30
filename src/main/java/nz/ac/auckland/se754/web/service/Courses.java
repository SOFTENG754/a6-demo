package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.auckland.se754.web.backend.model.Course;
import nz.ac.auckland.se754.web.backend.model.Lesson;
import nz.ac.auckland.se754.web.backend.model.Task;
import nz.ac.auckland.se754.web.model.CourseItem;
import nz.ac.auckland.se754.web.model.Item;
import org.springframework.stereotype.Service;

@Service
public class Courses {
    private final List<CourseItem> items;
    private final Map<String,List<CourseItem>> courses2user;
    public Courses(){
        items = new ArrayList<>();
        courses2user = new HashMap<>();
        Course course1 = new Course(new Lesson[]{new Lesson()});
        Course course2 = new Course(new Lesson[]{new Lesson()});
        Course course3 = new Course(new Lesson[]{new Lesson()});
        Course course4 = new Course(new Lesson[]{new Lesson()});
        Course course5 = new Course(new Lesson[]{new Lesson()});
        items.add(new CourseItem(1, "Course1", course1, "", "Not Started"));
        items.add(new CourseItem(2, "Course2", course2, "", "Not Started"));
        items.add(new CourseItem(3, "Course3", course3, "Interested", "Not Started"));
        items.add(new CourseItem(4, "Course4", course4, "", "In Progress"));
        items.add(new CourseItem(5, "Course5", course5, "Interested", "Completed"));
        courses2user.put("newUser", Arrays.asList(items.get(0), items.get(1)));
        courses2user.put("returnUser", Arrays.asList(items.get(2), items.get(3), items.get(4)));
    }

    public List<CourseItem> retrieveCourses(String user) {
        List<CourseItem> filteredItems = new ArrayList<>();
        if (courses2user.containsKey(user)) {
            filteredItems.addAll(courses2user.get(user));
        }
        return filteredItems;
    }

    public void toggleInterest(int id) {
        CourseItem courseItem = items.get(id-1);
        courseItem.setInterest("Interested");
    }
}