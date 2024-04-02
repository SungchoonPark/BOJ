import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            Integer i1 = map.get(s);
            if (i1 == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((o1, o2) -> {
            Integer value1 = o1.getValue();
            Integer value2 = o2.getValue();

            if (value1 == value2) return o1.getKey().compareTo(o2.getKey());
            return value2 - value1;
        });

        String key = entryList.get(0).getKey();
        System.out.println(key);

    }
}
