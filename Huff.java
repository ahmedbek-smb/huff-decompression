package decomphuff;

import java.io.*;
import java.util.*;

public class Huff {
    public static PriorityQueue<Node> Queue;
    public static HashMap<Character, String> hash2;
    public static HashMap<String, Character> hash1;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {
        String text = new Scanner(new File("exemple_comp.txt")).useDelimiter("\\A").next(); 
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            if(dict.containsKey(a))
                dict.put(a, dict.get(a)+1);
            else
                dict.put(a, 1);
        }

 
        Queue = new PriorityQueue<Node>(100, new Frequ());
        int n = 0;
        for(Character c : dict.keySet()) {
            Queue.add(new Node(c, dict.get(c)));
            n++;
        }
        Node root = huff(n);
        table(root);

        String compressed = compress(text);
        saveToFile(compressed);

        String decompressed = decompress(compressed);
        writeToFile(decompressed);
    }

    


    
    public static void order(Node n, String s) {
        if(n == null)
            return;
        order(n.left, s+"0");
        order(n.right, s+"1");

      
        if (!Character.toString(n.charac).equals("&#092;&#048;")){
            System.out.println("{" + n.charac + ":" + s + "}");
            hash2.put(n.charac, s);
            hash1.put(s, n.charac);
        }
    }

    
    public static String compress(String a) {
        String b = new String();
        for(int i = 0; i < a.length(); i++)
            b = b + hash2.get(a.charAt(i));
        return b;
    }

    public static Node huff(int n) {
        Node x, y;
        for(int i = 1; i <= n-1; i++) {
            Node z = new Node();
            z.left = x = Queue.poll();
            z.right = y = Queue.poll();
            z.value = x.value + y.value;
            Queue.add(z);
        }
        return Queue.poll();
    }

  
    public static String decompress(String s) {
        String temp = new String();
        String result = new String();
        for(int i = 0; i < s.length(); i++) {
            temp = temp + s.charAt(i);
            Character c = hash1.get(temp);
            if(c!=null && c!=0) {
                result = result + c;
                temp = "";
            }
        }
        return result;
    }
    public static void table(Node root) {
        hash2 = new HashMap<Character, String>();
        hash1 = new HashMap<String, Character>();
        order(root, new String());
    }

    public static void saveToFile(String a) throws FileNotFoundException {
        PrintWriter oFile = new PrintWriter("comp.txt.huf");
        oFile.print(hash2.size());
        for(char k : hash2.keySet())
            oFile.println("{" +k + ":" + hash2.get(k)+ "}");
        oFile.println(a);
        oFile.close();
    }

    public static void writeToFile(String f) throws FileNotFoundException {
        PrintWriter iFile = new PrintWriter("decomp.txt");
        iFile.print(hash1.size());
        for (String k1 : hash1.keySet())
            iFile.println("{" +k1 + ":" + hash1.get(k1)+ "}");
        iFile.println(f);
        iFile.close();
    }
}