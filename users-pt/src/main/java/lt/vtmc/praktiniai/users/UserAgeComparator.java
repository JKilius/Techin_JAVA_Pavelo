package lt.vtmc.praktiniai.users;

import java.util.Comparator;

public class UserAgeComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {

        return user1.getAge()-user2.getAge();
//        if(user1.getAge()>user2.getAge()){return 1;}
//        if(user1.getAge()<user2.getAge()){return -1;}
//        return 0;
    }
}
