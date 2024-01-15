package lt.techin.PavelS;

import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImpl implements Philatelist {
    List<PostStamp> postStamps = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {
        if (postStamp == null ||  postStamp.getName() == null || postStamp.getName().isBlank())
            throw new IllegalArgumentException();
        postStamps.add(postStamp);
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return postStamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        for (PostStamp postStamp : postStamps) {
            System.out.println(postStamp.getName());
        }

    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double price) {
        for (PostStamp postStamp : postStamps) {
            if (postStamp.getMarketPrice() > price) System.out.println(postStamp.getName());
        }
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        if (isPostStampWithNameInCollection(postStamp.getName())) return true;
        return false;
    }

    @Override
    public boolean isPostStampWithNameInCollection(String name) {
        for (PostStamp stamp : postStamps) {
            if (stamp.getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public double calculateTotalMarketPrice() {
        double total = 0;
        for (PostStamp postStamp : postStamps) {
            total += postStamp.getMarketPrice();
        }
        return total;
    }

    @Override
    public double getAveragePostStampPrice() {
        return calculateTotalMarketPrice() / getNumberOfPostStampsInCollection();
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        double max = 0;
        PostStamp mostExpensiveStamp = new PostStamp("", 0, 0);
        for (PostStamp stamp : postStamps) {
            if (stamp.getMarketPrice() > max) {
                max = stamp.getMarketPrice();
                mostExpensiveStamp = stamp;
            }
        }
        return mostExpensiveStamp;
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String nameFragment) {
        List<PostStamp> matchingStamps = new ArrayList<>();
        for (PostStamp postStamp : postStamps) {
            if (postStamp.getName().contains(nameFragment)) matchingStamps.add(postStamp);
        }
        return matchingStamps;
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        List<PostStamp> sortedStamps = postStamps;
        Collections.sort(sortedStamps, new PostStampComparator());
        return sortedStamps;
    }
}
