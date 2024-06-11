import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp = 0;
        sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<3; i++) {
            int x = Integer.parseInt(br.readLine());
            set.add(x);
            tmp += x;
        }
       if (set.size() == 1 && tmp == 180) {
           sb.append("Equilateral");
       } else if (set.size() == 2 && tmp == 180) {
           sb.append("Isosceles");
       } else if (set.size() == 3 && tmp == 180) {
           sb.append("Scalene");
       } else{
           sb.append("Error");
       }
        System.out.println(sb);
    }
}
