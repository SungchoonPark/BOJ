import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[] result = new int[num];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idx = new Stack<>();

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());

            if (i == num - 1) {
                // 마지막 수가 들어온 경우
                result[i] = -1;
                while (!stack.isEmpty() && stack.peek() < tmp) {
                    // stack 값이 tmp보다 작으니 이를 결과 배열에 반영해줘야함.
                    stack.pop();
                    result[idx.pop()] = tmp;
                }
            } else {
                // 값이 계속 들어오는 상황
                if (stack.isEmpty()) {
                    // 스택에 아무 값도 없는 상황 -> 그냥 스택에 넣어주면 됨, 그리고 idx++ 해주기
                    stack.push(tmp);
                    idx.push(i++);
                } else {
                    // 스택에 값이 있으면 이 값이랑 비교를 해야됨 -> while로 tmp보다 큰게 나올때까지 반복해야됨
                    while (!stack.isEmpty() && stack.peek() < tmp) {
                        // stack 값이 tmp보다 작으니 이를 결과 배열에 반영해줘야함.
                        stack.pop();
                        result[idx.pop()] = tmp;
                    }

                    // 스택 값보다 작은 경우임 -> 이는 stack에 넣어주면 됨
                    stack.push(tmp);
                    idx.push(i++);
                }
            }
        }

        // stack이 비어있지 않으면 얘네 다 -1로 만들어야함
        while(!idx.isEmpty()) {
            result[idx.pop()] = -1;
        }

        for (int j = 0; j < num; j++) {
            sb.append(result[j] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}