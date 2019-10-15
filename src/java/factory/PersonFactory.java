package java.factory;

import java.enums.UserType;
import java.person.Person;
import java.person.Student;
import java.person.Teacher;

public class PersonFactory {

    public Person getPerson(UserType userType){
        Person person = null;
        switch (userType){
            case STUDENT:
                person = new Student();
                break;
            case TEACHER:
                person = new Teacher();
                break;
        }
        return person;
    }
}
