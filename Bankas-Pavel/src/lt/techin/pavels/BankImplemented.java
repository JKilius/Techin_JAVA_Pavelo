package lt.techin.pavels;

import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BankImplemented implements Bank {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account openDebitAccount(String accountHolderName) {
        if (accounts.stream().anyMatch(x -> x.getHolderName().equals(accountHolderName))) return null;
        Account newAccount = new DebitAccount(accountHolderName, randomAccNumberGenerator());
        accounts.add(newAccount);
        return newAccount;
    }

    @Override
    public Account openCreditAccount(String accountHolderName, BigDecimal bigDecimal) {
        if (accounts.stream().anyMatch(x -> x.getHolderName().equals(accountHolderName))) return null;
        Account newAccount = new CreditAccount(accountHolderName, randomAccNumberGenerator(), bigDecimal);
        accounts.add(newAccount);
        return newAccount;
    }

    @Override
    public Account getAccountByHolderName(String accountHolderName) {
        return accounts.stream().filter(account -> account.getHolderName().equals(accountHolderName)).findAny().orElse(null);
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accounts.stream().filter(account -> account.getNumber().equals(accountNumber)).findAny().orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    private String randomAccNumberGenerator() {
        Random random = new Random();
        String accountHolderNumber;
        while (true) {
            accountHolderNumber = random.ints(0, 10)
                    .limit(10)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining());
            String finalAccountHolderNumber = accountHolderNumber;
            if (accounts.stream().noneMatch(x -> x.getNumber().equals(finalAccountHolderNumber))) break;
        }
        return accountHolderNumber;
    }
}
