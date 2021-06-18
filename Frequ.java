package decomphuff;

import java.util.Comparator;

public class Frequ implements Comparator<Node> {
    public int compare(Node a, Node b) {
        int A = a.value;
        int B = b.value;
        return A-B;
    }

}
