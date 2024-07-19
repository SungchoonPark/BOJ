import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<String> list;
    static int[] cntHack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();

        int r = 0;
        for (int i = 0; i < 3; i++) {
            String tmp = br.readLine();
            if (!tmp.contains("Fizz") && !tmp.contains("Buzz")) {
                r = Integer.parseInt(tmp) + (3-i);
            }
            list.add(tmp);
        }
        if(r % 3 == 0 && r % 5 == 0) sb.append("FizzBuzz");
        else if(r % 3 == 0) sb.append("Fizz");
        else if(r % 5 == 0) sb.append("Buzz");
        else sb.append(r);

        System.out.print(sb);
    }
}
