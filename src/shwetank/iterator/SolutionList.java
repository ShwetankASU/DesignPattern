package shwetank.iterator;

import shwetank.solution.Solution;

import java.util.List;
//Iterator Design Pattern

public class SolutionList extends ArrayList<Solution> {

    public SolutionList(List<Solution> solutionList) {
        super(solutionList);
    }
}
