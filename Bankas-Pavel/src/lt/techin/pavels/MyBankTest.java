package lt.techin.pavels;

import ibank.Bank;
import ibank.BaseBankTest;

public class MyBankTest extends BaseBankTest {
    @Override
    protected Bank createBank() {
        return new BankImplemented();
    }
}
