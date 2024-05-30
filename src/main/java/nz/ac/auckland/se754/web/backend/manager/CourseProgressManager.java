package nz.ac.auckland.se754.web.backend.manager;

import nz.ac.auckland.se754.web.backend.exception.NoLessonException;
import nz.ac.auckland.se754.web.backend.model.Course;
import nz.ac.auckland.se754.web.backend.model.CourseProgress;
import nz.ac.auckland.se754.web.backend.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CourseProgressManager {
    private final Map<UserCoursePair, CourseProgress> progressMap;

    public CourseProgressManager() {
        progressMap = new HashMap<>();
    }
    public CourseProgress getCourseProgress(User user, Course course) {
        UserCoursePair userCoursePair = new UserCoursePair(user, course);
        return progressMap.get(userCoursePair);
    }

    public void startCourseProgress(User user, Course course) throws NoLessonException {
        UserCoursePair pair = new UserCoursePair(user, course);
        if(!progressMap.containsKey(pair)) {
            CourseProgress progress = new CourseProgress(user, course);
            progress.startProgress();
            progressMap.put(pair, progress);
        }
    }
}

class UserCoursePair{
    private final User user;
    private final Course course;

    public UserCoursePair(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCoursePair)) return false;
        UserCoursePair that = (UserCoursePair) o;
        return user.equals(that.user) && course.equals(that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, course);
    }
}