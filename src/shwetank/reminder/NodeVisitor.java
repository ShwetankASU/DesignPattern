package shwetank.reminder;

import shwetank.facade.FacadeManager;
import shwetank.assignment.Assignment;
import shwetank.course.Course;

public abstract class NodeVisitor {

    public abstract void visitFacade(FacadeManager facademanager);
    public abstract void visitAssignment(Assignment assignment);
    public abstract void visitCourse(Course course);

}
