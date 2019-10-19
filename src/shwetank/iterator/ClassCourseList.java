package shwetank.iterator;

import shwetank.course.Course;
//Iterator Design Pattern
//Visitor Design Pattern
import java.util.List;

public class ClassCourseList extends ArrayList<Course> {

    public ClassCourseList(List<Course> courses){
        super(courses);
    }

}
