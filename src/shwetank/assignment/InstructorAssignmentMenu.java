package shwetank.assignment;

public class InstructorAssignmentMenu extends AssignmentMenu {

    public InstructorAssignmentMenu(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void showAssignmentMenu() {
        System.out.println("Add assignment by instructor");
    }

    @Override
    public void viewAssignment() {
        System.out.println("View assignment by instructor");
    }
}
