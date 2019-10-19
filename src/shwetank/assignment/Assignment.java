package shwetank.assignment;

import shwetank.iterator.SolutionList;
import shwetank.reminder.NodeVisitor;
import shwetank.reminder.Reminder;

import java.util.Date;
//Visitor Design Pattern

public class Assignment implements Reminder {
    private String assignmentText;
    private SolutionList solutionList;
    private Date dueDate;
    private boolean isSubmitted;

    public Assignment(String assignmentText, Date dueDate) {
        this.assignmentText = assignmentText;
        this.dueDate = dueDate;
    }

    public SolutionList getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(SolutionList solutionList) {
        this.solutionList = solutionList;
    }

    public String getAssignmentText() {
        return assignmentText;
    }

    public void setAssignmentText(String assignmentText) {
        this.assignmentText = assignmentText;
    }

    Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    public void submitAssignment() { this.isSubmitted = true; }

    boolean isAssignmentSubmitted() { return this.isSubmitted; }

    @Override
    public void addNodeVisitor(NodeVisitor nodeVisitor) {
        nodeVisitor.visitAssignment(this);
    }
}
