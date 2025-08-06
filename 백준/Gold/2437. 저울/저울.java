import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreElements()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int sum = 0;
        for (Integer i : list) {
            if (i > sum + 1) {
                System.out.println(sum + 1);
                return;
            }

            sum += i;
        }

        System.out.println(sum + 1);
    }

}