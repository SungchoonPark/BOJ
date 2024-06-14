import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();


        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> diff1 = new HashSet<>(set);
        Set<Integer> diff2 = new HashSet<>(set1);
        diff1.removeAll(set1);
        diff2.removeAll(set);

        System.out.println(diff1.size() + diff2.size());
    }
}
