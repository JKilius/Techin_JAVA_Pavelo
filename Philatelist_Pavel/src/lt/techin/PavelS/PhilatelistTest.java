package lt.techin.PavelS;

import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PhilatelistBaseTest;

public class PhilatelistTest extends PhilatelistBaseTest {
    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImpl();
    }
}
