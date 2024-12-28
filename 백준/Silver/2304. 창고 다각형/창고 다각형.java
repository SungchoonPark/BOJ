import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[x] = h;
            start = Math.min(start, x);
            end = Math.max(end, x);
        }

        Stack<Integer> stack = new Stack<>();
        int tmpH = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (tmpH > arr[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    arr[stack.pop()] = tmpH;
                }
                
                tmpH = arr[i];
            }
        }

        stack.clear();

        tmpH = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (tmpH > arr[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    arr[stack.pop()] = tmpH;
                }

                tmpH = arr[i];
            }
        }

        int result = 0;
        for (int i = start; i < end + 1; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}