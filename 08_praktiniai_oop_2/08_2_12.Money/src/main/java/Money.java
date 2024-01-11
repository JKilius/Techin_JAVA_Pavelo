
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        return new Money(euros + addition.euros(), cents + addition.cents());
    }

    public boolean lessThan(Money compared) {
        return euros * 100 + cents < compared.euros() * 100 + compared.cents();
    }

    public Money minus(Money decreaser) {

        if (!lessThan(decreaser)) {
            if ((cents - decreaser.cents()) >= 0) {
                return new Money(euros - decreaser.euros(), cents - decreaser.cents());
            }
            return new Money(euros - decreaser.euros() - 1, 100 - cents - decreaser.cents());
        }
        return new Money(0, 0);
    }
}
