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


        HashSet<String> set = new HashSet<>();
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String record = st.nextToken();

            if(record.equals("leave")) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        List<String> arr = new ArrayList<>(set);
        arr.sort(Collections.reverseOrder());

        for (String s : arr) {
            System.out.println(s);
        }

    }
}

