public class Song {
    private String name;
    private int seconds;

    public Song(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }
    public String name(){
        return name;
    }

    public int length() {
        return seconds;
    }
}
