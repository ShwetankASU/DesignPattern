package shwetank.assignment;

import shwetank.iterator.list.SolutionList;

import java.util.Date;

public class Assignment {
    private String assignmentText;
    private SolutionList solutionList;
    private Date dueDate;

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
}
