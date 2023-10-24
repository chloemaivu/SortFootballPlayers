import java.util.Comparator;

public class NumSort implements Comparator <Player> {
        public int compare(Player a, Player b) {
            return a.squadNum - b.squadNum;
        }
    }

