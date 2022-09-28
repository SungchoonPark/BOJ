import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        // 큐의 크기 n
        int n = Integer.parseInt(st.nextToken());
        // 뽑아내력 하는 수의 개수
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> nums = new LinkedList<>();
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            nums.add(tmp);
        }

        int count = 0;
        for(Integer i : nums) {
            int indexNum = deque.indexOf(i);

            int half;
            if(deque.size() % 2 == 0) {
                half = deque.size() / 2-1;
            } else {
                half = deque.size()/2;
            }

            if(indexNum <= half) {
                // 2번 시행
                for(int j=0; j< indexNum; j++) {
                    int tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                    count++;
                }
            } else {
                // 3번 시행
                for(int j=0; j< deque.size() - indexNum; j++) {
                    int tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);

    }
}