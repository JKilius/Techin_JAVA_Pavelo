package lt.techin.pavels;

import lt.vtvpmc.java.postoffice.AbstractPostOfficeTest;
import lt.vtvpmc.java.postoffice.PostOffice;

public class MyTest extends AbstractPostOfficeTest {
    @Override
    protected PostOffice getPostOffice() {
        return new PostOfficeImplemented();
    }
}
