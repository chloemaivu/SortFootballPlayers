public class Player {
    String name;
    int squadNum;

    public Player(String name, int squadNum) {
        this.name = name;
        this.squadNum = squadNum;
    }

    public String toString() {
        return this.squadNum + " " + this.name;
    }
}
