package exceptions;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("Course not found in Repository");
    }
}
