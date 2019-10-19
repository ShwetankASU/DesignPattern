package shwetank.solution;

public class Solution {
    private String mSolution;
    private int mGrade;
    private boolean mIsGraded = false;
    private boolean mIsReported = false;

    public Solution(String solution) {
        mSolution = solution;
    }

    public String getSolution() {
        return mSolution;
    }

    public int getGrade() {
        return mGrade;
    }

    public void setGrade(int grade) {
        mIsGraded = true;
        mGrade = grade;
    }

    public boolean isGraded() {
        return mIsGraded;
    }

    public boolean isReported() {
        return mIsReported;
    }

    public void reportSolution() {
        mIsReported = true;
    }

}
