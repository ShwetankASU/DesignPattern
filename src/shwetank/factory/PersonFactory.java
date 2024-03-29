package shwetank.factory;

import shwetank.enums.UserType;
import shwetank.person.Person;
import shwetank.person.Student;
import shwetank.person.Instructor;

public class PersonFactory {

    public Person getPerson(UserType userType){
        return userType == UserType.STUDENT ? new Student() : new Instructor();
    }
}
