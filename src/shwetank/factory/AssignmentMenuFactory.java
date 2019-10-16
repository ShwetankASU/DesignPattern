package shwetank.factory;

import shwetank.assignment.AssignmentMenu;
import shwetank.assignment.StudentAssignmentMenu;
import shwetank.enums.UserType;
import shwetank.assignment.InstructorAssignmentMenu;

public class AssignmentMenuFactory {

    public AssignmentMenu getAssignmentMenu(UserType userType) {
        AssignmentMenu assignmentMenu = null;
        switch (userType){
            case STUDENT:
                assignmentMenu = new StudentAssignmentMenu();
                break;
            case TEACHER:
                assignmentMenu = new InstructorAssignmentMenu();
                break;
        }
        return assignmentMenu;
    }

}
