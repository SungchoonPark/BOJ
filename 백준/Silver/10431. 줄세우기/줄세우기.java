import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int walkCount = 0;
            int testNumber = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                int stuHeight = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    list.add(stuHeight);
                    continue;
                }

                int curSize = list.size();
                boolean tmp = false;
                for (int i1 = 0; i1 < curSize; i1++) {
                    if (stuHeight < list.get(i1)) {
                        walkCount += list.size() - i1;
                        list.add(i1, stuHeight);
                        tmp = true;
                        break;
                    }
                }

                if (!tmp) list.add(stuHeight);
            }

            sb.append(testNumber).append(" ").append(walkCount).append("\n");
        }

        System.out.print(sb);
    }
}