import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    // 삽입
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (command.equals("D")) {
                    // 삭제
                    if (map.isEmpty()) continue;

                    if (value == -1) {
                        // 최소값 삭제
                        int minKey = map.firstKey();
                        if (map.put(minKey, map.get(minKey) - 1) == 1) {
                            map.remove(minKey);
                        }
                    } else {
                        // 최대값 삭제
                        int maxKey = map.lastKey();
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1) {
                            map.remove(maxKey);
                        }
                    }
                }
            }

            // 결과 출력
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}