import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            int commandCount = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int i1 = 0; i1 < commandCount; i1++) {
                st = new StringTokenizer(br.readLine());

                String com = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (com.equals("I")) {
                    if (tm.get(value) != null) {
                        tm.put(value, tm.get(value) + 1);
                    } else {
                        tm.put(value, 1);
                    }
                } else if (com.equals("D") && !tm.isEmpty()) {
                    if (value == -1) {
                        // 최소값 삭제 (단, 같은 값이 복수개일 경우 하나만 삭제한다)
                        Integer min = tm.get(tm.firstKey());

                        if (min <= 1) {
                            tm.remove(tm.firstKey());
                        } else {
                            tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                        }
                    } else {
                        // 최대값 삭제
                        Integer max = tm.get(tm.lastKey());

                        if (max <= 1) {
                            tm.remove(tm.lastKey());
                        } else {
                            tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                        }
                    }
                }
            }

            if (tm.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }
        System.out.print(sb);

    }

}