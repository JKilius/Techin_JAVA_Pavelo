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
//        postStamps.stream().filter(postStamps -> postStamp != null && postStamp.getName() != null && postStamp.getName().isEmpty()).forEachOrdered(postStamps::add);
        if (postStamp == null || postStamp.getName() == null || postStamp.getName().isBlank())
            throw new IllegalArgumentException();
        postStamps.add(postStamp);
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return postStamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        postStamps.forEach(postStamp -> System.out.println(postStamp.getName()));
//        for (PostStamp postStamp : postStamps) {
//            System.out.println(postStamp.getName());
//        }

    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double price) {
//        postStamps.stream().filter(postStamp -> postStamp.getMarketPrice() > price).forEach(System.out::println);
        postStamps.stream().filter(postStamp -> postStamp.getMarketPrice() > price).forEach(postStamp -> System.out.println(postStamp.getName()));
//        for (PostStamp postStamp : postStamps) {
//            if (postStamp.getMarketPrice() > price) System.out.println(postStamp.getName());
//        }
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        return postStamps.contains(postStamp);
    }

    @Override
    public boolean isPostStampWithNameInCollection(String name) {
        return postStamps.stream().anyMatch(postStamp -> postStamp.getName().equals(name));
//        for (PostStamp stamp : postStamps) {
//            if (stamp.getName().equals(name)) return true;
//        }
//        return false;
    }

    @Override
    public double calculateTotalMarketPrice() {
        return postStamps.stream().mapToDouble(PostStamp::getMarketPrice).sum();
//        double total = 0;
//        for (PostStamp postStamp : postStamps) {
//            total += postStamp.getMarketPrice();
//        }
//        return total;
    }

    @Override
    public double getAveragePostStampPrice() {
        return calculateTotalMarketPrice() / getNumberOfPostStampsInCollection();
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        return postStamps.stream().max(Comparator.comparing(PostStamp::getMarketPrice)).orElse(null);
//        double max = 0;
//        PostStamp mostExpensiveStamp = new PostStamp("", 0, 0);
//        for (PostStamp stamp : postStamps) {
//            if (stamp.getMarketPrice() > max) {
//                max = stamp.getMarketPrice();
//                mostExpensiveStamp = stamp;
//            }
//        }
//        return mostExpensiveStamp;
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String nameFragment) {
        return postStamps.stream().filter(postStamp -> postStamp.getName().contains(nameFragment)).toList();
//        List<PostStamp> matchingStamps = new ArrayList<>();
//        for (PostStamp postStamp : postStamps) {
//            if (postStamp.getName().contains(nameFragment)) matchingStamps.add(postStamp);
//        }
//        return matchingStamps;
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
//        return postStamps.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).toList();
        return postStamps.stream().sorted(Comparator.comparing(PostStamp::getName)).toList();

//        List<PostStamp> sortedStamps = postStamps;
//        Collections.sort(sortedStamps, new PostStampComparator());
//        return sortedStamps;
    }
}
