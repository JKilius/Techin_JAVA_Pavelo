package lt.techin.pavels;

import java.math.BigDecimal;

public class DefaultAccount extends AccountImpl {
    private String number;
    private BigDecimal balance;
    private String holderName;
    public DefaultAccount(String holderName, String holderAccNumber) {
        this.holderName = holderName;
        number = holderAccNumber;
        balance = BigDecimal.ZERO;
    }
    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        balance = balance.add(bigDecimal);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {
        if (balance.compareTo(bigDecimal)>=0) {
            balance=balance.subtract(bigDecimal);
            return true;
        }
        return false;
    }
}
