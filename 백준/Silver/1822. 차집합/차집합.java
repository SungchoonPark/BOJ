import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> aset = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aset.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int bvalue = Integer.parseInt(st.nextToken());
            aset.remove(bvalue);
        }

        if (aset.isEmpty()) {
            System.out.println(0);
            return;
        }
        sb.append(aset.size()).append("\n");
        for (Integer i : aset) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}