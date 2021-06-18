package decomphuff;

public class Node {
    public char charac;
    public int value;
    public Node left, right;

    public Node(char a, int f) {
        charac = a;
        value = f;
    }  
    public Node() {
    } 
    public String toString() {
        return charac + " " + value;
    }
} 