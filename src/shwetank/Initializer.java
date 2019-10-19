package shwetank;

import shwetank.enums.UserType;
import shwetank.facade.FacadeManager;
import shwetank.facade.FacadeManagerImpl;
import shwetank.person.UserInfoItem;

import java.util.Scanner;

public class Initializer {

    public static void main(String[] args){

        FacadeManager facadeManager = FacadeManagerImpl.getFacadeManager();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            print("Press 1 for Sign Up");
            print("Press 2 for Login");
            print("Press 3 for Exit");
            int input = scanner.nextInt();

            if (input == 3) {
                break;
            }

            print("Please enter your User Name:");
            String userName = scanner.next();

            print("Please enter your Password:");
            String password = scanner.next();


            if(input == 1){
                facadeManager.createUser(new UserInfoItem(UserType.INSTRUCTOR, userName, password));
            }

            boolean isLoggedIn = facadeManager.doLogin(userName, password);
            if(isLoggedIn){

                //Create Course From Database Manager
                facadeManager.createCourseList();

                //select a course on which you want to perform operations
                facadeManager.selectCourse();
                facadeManager.attachCourseToUser();

                //perform some operations
                facadeManager.courseOperation();

                //Add assignment
                print("Please enter your Assignment: ");
                String assignment = scanner.next();
                facadeManager.addAssignment(assignment);

                facadeManager.viewAssignment();

                facadeManager.submitSolution();
                facadeManager.gradeSolution();
                facadeManager.reportSolutions();
                facadeManager.remind();
                facadeManager.invalidate();
                print("you have been logged out");
                print("Sign in again");
            }
        }
    }

    private static void print(String message){
        System.out.println(message);
    }

}
