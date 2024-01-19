package lt.techin.pavels;

import jdk.jfr.Frequency;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SocialNetworkImpl implements SocialNetwork {

    List<Friend> network = new ArrayList<>();

    @Override
    public void addFriend(Friend friend) {
        if (friend == null) throw new IllegalArgumentException();
        if (!network.contains(friend)) {
            network.add(friend);
        }

    }

    @Override
    public int getNumberOfFriends() {
        if (network == null) return 0;
        return network.size();
    }

    @Override
    public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
        if(firstName == null || lastName == null) throw new IllegalArgumentException();

        return network.stream().filter(friend1 -> friend1.getFirstName()
                        .equals(firstName) && friend1.getLastName().equals(lastName))
                .findFirst().orElseThrow(() -> new FriendNotFoundException(firstName, lastName));
    }

    @Override
    public Collection<Friend> findByCity(String city) {
        if (city == null) throw new IllegalArgumentException();
        return network.stream().filter(friend -> friend.getCity().equals(city)).collect(Collectors.toList());
    }

    @Override
    public Collection<Friend> getOrderedFriends() {
        return network.stream()
                .sorted(Comparator.comparing(Friend::getCity).thenComparing(Friend::getLastName).thenComparing(Friend::getFirstName)).collect(Collectors.toList());
    }
}
