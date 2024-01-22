package lt.techin.pavels;

import lt.techin.library.BookCatalog;
import lt.techin.library.test.AbstractLibraryTest;

public class MyTest extends AbstractLibraryTest {
    @Override
    protected BookCatalog createBookCatalog() {
        return new LibraryImplementation();
    }
}
