package shwetank.solution;

public class Solution {
    private String solution;
    private int grade;
    private boolean isGraded = false;

    public Solution(String solution){
        this.solution = solution;
    }

    public String getSolution(){
        return solution;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }
}
