package shwetank.factory;

import shwetank.assignment.Assignment;
import shwetank.assignment.AssignmentMenu;
import shwetank.assignment.StudentAssignmentMenu;
import shwetank.enums.UserType;
import shwetank.assignment.InstructorAssignmentMenu;

public class AssignmentMenuFactory {

    public AssignmentMenu getAssignmentMenu(UserType userType, Assignment assignment) {
        if (userType == UserType.STUDENT) {
            return new StudentAssignmentMenu(assignment);
        } else {
            return new InstructorAssignmentMenu(assignment);
        }
    }
}
