import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Value> values = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            values.add(new Value(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int currentIndex = 0;

        while (!values.isEmpty()) {
            Value value = values.remove(currentIndex);
            sb.append(value.idx).append(" ");
            if (values.isEmpty()) break;

            int moveCnt = value.moveCnt;
            if (moveCnt < 0) {
                currentIndex = (currentIndex + moveCnt) % values.size();
                if (currentIndex < 0) currentIndex += values.size();
            } else {
                currentIndex = (currentIndex + moveCnt - 1) % values.size();
            }
        }

        System.out.println(sb);
    }

    static class Value {
        int idx;
        int moveCnt;

        public Value(int idx, int moveCnt) {
            this.idx = idx;
            this.moveCnt = moveCnt;
        }
    }
}