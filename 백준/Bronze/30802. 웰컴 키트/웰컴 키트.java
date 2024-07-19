import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> list;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int tResult = 0;
        
        for (Integer i : list) {
            if (i != 0 && i <= t) tResult++;
            else if (i > t){
                if (i % t == 0) tResult += i/t;
                else tResult = tResult + (i / t + 1);
            }
        }

        sb.append(tResult).append("\n");
        sb.append(n/p).append(" ").append(n%p);
        System.out.print(sb);
    }
}
