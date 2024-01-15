package lt.techin.PavelS;

import lt.techin.philatelist.PostStamp;

import java.util.Comparator;

public class PostStampComparator implements Comparator<PostStamp> {
    @Override
    public int compare(PostStamp postStamp1, PostStamp postStamp2) {
        return postStamp1.getName().compareTo(postStamp2.getName());
    }
}
