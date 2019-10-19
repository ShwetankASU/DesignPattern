package shwetank.reminder;

import shwetank.facade.FacadeManager;
import shwetank.assignment.Assignment;
import shwetank.course.Course;

public class ReminderVisitor extends NodeVisitor{

    private Reminder mReminder;

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
