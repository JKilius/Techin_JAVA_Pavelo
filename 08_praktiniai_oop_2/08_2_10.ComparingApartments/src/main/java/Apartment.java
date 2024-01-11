
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public boolean largerThan (Apartment compared){
        return squares > compared.getSquares();
    }

    public int priceDifference (Apartment compared){
        return Math.abs(princePerSquare*squares - compared.princePerSquare*compared.squares);
    }

    public boolean moreExpensiveThan (Apartment compared){
        return (princePerSquare*squares > compared.princePerSquare*compared.squares);
    }
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getSquares() {
        return squares;
    }

    public void setSquares(int squares) {
        this.squares = squares;
    }

    public int getPrincePerSquare() {
        return princePerSquare;
    }

    public void setPrincePerSquare(int princePerSquare) {
        this.princePerSquare = princePerSquare;
    }
}
