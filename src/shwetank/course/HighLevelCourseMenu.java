package shwetank.course;
//Bridge Design Pattern
//Factory Design Pattern
public class HighLevelCourseMenu extends CourseMenu {

    @Override
    public void showAddButton() {
        System.out.println("show High level course Add button");
    }

    @Override
    public void showViewButton() {
        System.out.println("show High level course View button");
    }

    @Override
    public void showRadioButton() {
        System.out.println("show High level course Radio button");
    }

    @Override
    public void showComBoxes() {
        System.out.println("show High level course  ComBoxes");
    }

    @Override
    public void showLabels() {
        System.out.println("show High level course Labels");
    }

    @Override
    public void showMenu() {
        System.out.println("show High level course Menu");
    }

}
