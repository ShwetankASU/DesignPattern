package shwetank;

import shwetank.enums.UserType;
import shwetank.interfaces.FacadeManager;
import shwetank.person.UserInfoItem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        FacadeManager facadeManager = FacadeManagerImpl.getFacadeManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Press \n 1) for login \n 2) for signup");

        int option = sc.nextInt();

        System.out.println("Please enter your username");
        String userName = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        if(option == 1){
            facadeManager.login(userName, password);
        }else if(option == 2){
            try {
                facadeManager.createUser(new UserInfoItem(UserType.TEACHER, userName, password));
                facadeManager.login(userName, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("You are Logged in!!");

        facadeManager.createCourseList();

        facadeManager.selectCourse();

        facadeManager.attachCourseToUser();

        facadeManager.courseOperation();

        facadeManager.addAssignment();

        facadeManager.viewAssignment();

        facadeManager.login("pepe","1111");
        facadeManager.addAssignment();
        facadeManager.viewAssignment();
    }

}
