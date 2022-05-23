import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer integer : set) {
            sb.append(integer).append(' ');
        }

        System.out.println(sb);



    }
}

