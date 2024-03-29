package shwetank.reminder;

import shwetank.facade.FacadeManager;
import shwetank.assignment.Assignment;
import shwetank.course.Course;
//Visitor Design Pattern

public class ReminderVisitor extends NodeVisitor{

    @Override
    public void visitFacade(FacadeManager facadeManager) {
        System.out.println("Visit Facade Manager");
    }

    @Override
    public void visitAssignment(Assignment assignment) {
        System.out.println("Visit Assignment");
    }

    @Override
    public void visitCourse(Course course) {
        System.out.println("Visit Course");
    }
}
