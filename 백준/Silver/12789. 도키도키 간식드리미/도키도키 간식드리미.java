import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int findNum = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == findNum) {
                findNum++;

                while (!stack.isEmpty() && stack.peek() == findNum) {
                    stack.pop();
                    findNum++;
                }
                continue;
            }

            stack.push(arr[i]);
        }

        if (stack.isEmpty() || (stack.size() == 1 && stack.peek() == findNum)) {
            System.out.println("Nice");
            return;
        }

        int prevNum = stack.pop();
        if (prevNum != findNum) {
            System.out.println("Sad");
            return;
        }

        while (!stack.isEmpty()) {
            Integer curNum = stack.pop();

            if (curNum == prevNum + 1) {
                prevNum = curNum;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}