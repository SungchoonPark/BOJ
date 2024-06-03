import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            stack.push(a);
        }

        while(true) {
            Integer pop = stack.pop();
            if (stack.isEmpty()) break;

            Integer tmp = stack.pop();
            if (pop <= tmp) {
                answer = answer + tmp - (pop - 1);
                stack.push(pop-1);
            } else {
                stack.push(tmp);
            }
        }

        System.out.println(answer);
    }
}
