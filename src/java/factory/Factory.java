package java.factory;

import java.enums.CourseLevelType;
import java.enums.UserType;
import java.person.Person;

public abstract class Factory {

     public abstract Person getPerson(UserType userType, CourseLevelType courseLevelType);

}
