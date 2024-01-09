public class PaymentCard {
    private double balance;

    public PaymentCard(double balance) {
        this.balance = balance;
    }

    public void eatAffordably() {
        if ((balance -2.60) >= 0) {
            balance -= 2.60;
        }
    }

    public void eatHeartily() {
        if ((balance - 4.60) >= 0) {
            balance -= 4.60;
        }
    }

    public void addMoney(double balance) {
        if (balance>=0) {
            if (this.balance + balance <150) {
                this.balance += balance;
            } else this.balance=150;
        }
    }


    @Override
    public String toString() {
        return "The card has a balance of " + balance + " euros";
    }
}
