package java.factory;

import java.assignment.AssignmentMenu;
import java.assignment.InstructorAssignmentMenu;
import java.assignment.StudentAssignmentMenu;
import java.enums.UserType;

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
