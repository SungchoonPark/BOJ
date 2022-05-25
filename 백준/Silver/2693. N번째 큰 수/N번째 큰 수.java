import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();

            for(int j=0; j<10; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);
            sb.append(arr.get(7)).append('\n');
        }

        System.out.println(sb);

    }
}

