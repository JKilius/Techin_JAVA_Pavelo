package lt.techin.pavels;

import java.math.BigDecimal;

public class CreditAccount extends DefaultAccount {
    private final BigDecimal creditLimit;

    public CreditAccount(String holderName, String holderAccNumber, BigDecimal creditLimit) {
        super(holderName, holderAccNumber);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        BigDecimal balance = super.getBalance();
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO)>=0 || newBalance.add(creditLimit).compareTo(BigDecimal.ZERO)>=0) {
            super.setBalance(newBalance);
            return true;
        }
//        if (balance.compareTo(amount) >= 0) {
//            super.setBalance(balance.subtract(amount));
//            return true;
//        } else if ((balance.add(creditLimit)).compareTo(amount)>=0){
//                super.setBalance(balance.subtract(amount));
//                return true;
//            }
        return false;
    }
}
