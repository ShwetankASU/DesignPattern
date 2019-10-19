package shwetank.assignment;

public class StudentAssignmentMenu extends AssignmentMenu {

    public StudentAssignmentMenu(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void showAssignmentMenu() {
        System.out.println("Add assignment by student");
    }

    @Override
    public void viewAssignment() {
        System.out.println("View assignment by student");
        if (assignment.isAssignmentSubmitted()) {
            System.out.println("assignment is submitted");
        } else {
            System.out.println("Assignment is not submitted and due on Data: " + assignment.getDueDate());
        }
    }
}
