package shwetank.assignment;

public abstract class AssignmentMenu {

    protected Assignment assignment;
    AssignmentMenu(Assignment assignment) {
        this.assignment = assignment;
    }

    public abstract void showAssignmentMenu();

    public abstract void viewAssignment();
}
