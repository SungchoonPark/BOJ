import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 0; i<str.length(); i++) {
            for(int j=i+1; j<=str.length(); j++) {
                String tmp = str.substring(i, j);
                set.add(tmp);
            }
        }
        System.out.println(set.size());

    }
}
