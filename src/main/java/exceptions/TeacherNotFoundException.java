package exceptions;

public class TeacherNotFoundException extends Exception{
    public TeacherNotFoundException() {
        super("Teacher not found in Repository");
    }
}
