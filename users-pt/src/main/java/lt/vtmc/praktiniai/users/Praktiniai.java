package lt.vtmc.praktiniai.users;

import java.util.Collections;
import java.util.List;

public class Praktiniai {

    public static Integer countUsersOlderThen25(List<User> users) {
        int count = 0;
        for (User user : users) {
            if (user.getAge() > 25) {
                count++;
            }
        }
        return count;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static int sumAge(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
        int sum = 0;
        for (User user : users) {
            sum += user.getAge();
        }
        return sum;
    }

    public static double getAverageAge(List<User> users) {
        return (double) sumAge(users) / users.size();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer getMinAge(List<User> users) {
        int minAge = 200;
        for (User user : users) {
            if (minAge > user.getAge()) {
                minAge = user.getAge();
            }
        }
        return minAge;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static User findByName(List<User> users, String name) {
        User userNotFound = new User("User Not Found");
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static User findOldest(List<User> users) {
        int ageOldest = 0;
        User userOldest = new User(0);
        for (User user : users) {
            if (user.getAge() > ageOldest) {
                ageOldest = user.getAge();
                userOldest = user;
            }
        }
        return userOldest;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<User> sortByAge(List<User> users) {

        Collections.sort(users, new UserAgeComparator());
        return users;
//        throw new UnsupportedOperationException("Not implemented");
    }

}
