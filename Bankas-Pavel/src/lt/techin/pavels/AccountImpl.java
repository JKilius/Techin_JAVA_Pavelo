package lt.techin.pavels;

import ibank.Account;

import java.math.BigDecimal;

public abstract class AccountImpl implements Account {
    @Override
    public abstract String getNumber();

    @Override
    public abstract String getHolderName();

    @Override
    public abstract BigDecimal getBalance();

    @Override
    public abstract boolean deposit(BigDecimal bigDecimal);

    @Override
    public abstract boolean withdraw(BigDecimal bigDecimal);
}
