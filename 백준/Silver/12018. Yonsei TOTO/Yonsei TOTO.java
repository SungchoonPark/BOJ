import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int subjectCnt;
    static int mileage;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        subjectCnt = Integer.parseInt(st.nextToken());
        mileage = Integer.parseInt(st.nextToken());

        List<Integer> students;
        PriorityQueue<Integer> needMileages = new PriorityQueue<>();
        for (int i = 0; i < subjectCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int applyCnt = Integer.parseInt(st.nextToken());
            int limitCnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            if (applyCnt < limitCnt) {
                needMileages.add(1);
                continue;
            }

            students = new ArrayList<>();
            for (int j = 0; j < applyCnt; j++) {
                students.add(Integer.parseInt(st.nextToken()));
            }

            students.sort(Collections.reverseOrder());
            needMileages.add(students.get(limitCnt - 1));
        }

        int result = 0;
        while(!needMileages.isEmpty()) {
            Integer minMileage = needMileages.poll();
            if (mileage - minMileage >= 0) {
                mileage -= minMileage;
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}