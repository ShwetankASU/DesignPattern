package shwetank.factory;

import shwetank.enums.UserType;
import shwetank.person.Person;
import shwetank.person.Student;
import shwetank.person.Teacher;

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
