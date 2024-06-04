package nz.ac.auckland.se754.web.model;

public class Category {
    private String name;
    private final CourseItem[] courses;

    public Category(String name, CourseItem[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseItem[] getCourses() {
        return courses;
    }
}