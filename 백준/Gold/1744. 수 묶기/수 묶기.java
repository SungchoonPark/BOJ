import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 양수는 무조건 묶는게 좋음
        // 음수의 경우엔
        // 1. 음수가 짝수개인 경우
        // -> 그냥 음수끼리 곱해서 양수로 만들고 더해주는게 이득
        // -> 이때, 큰 수는 큰 수끼리 곱해서 더하기
        // 2. 음수가 홀수개인 경우
        // -> 제일 작은 음수 (-1)는 그냥 단일로 더해주고 나머지는 곱해서 더하기
        // -> 만약, 0이 존재한다면 0과 곱해서 상쇄시켜도 굿
        // 3. 음수가 없는 경우
        // -> 양수가 짝수개면 큰거대로 두개씩 묶어서 더해주기
        // -> 양수가 홀수개면 제일 작은거 빼고 두개씩 묶어서 더해주기
        PriorityQueue<Integer> minus = new PriorityQueue<>((i1, i2) -> i1 - i2);
        PriorityQueue<Integer> plus = new PriorityQueue<>((i1, i2) -> i2- i1);

        int n = Integer.parseInt(br.readLine());


        int minusCnt = 0;
        boolean zeroExist = false;
        int plusCnt = 0;

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());

            if (v == 0) zeroExist = true;
            else if (v > 0) {
                plusCnt++;
                plus.add(v);
            } else {
                minusCnt++;
                minus.add(v);
            }
        }

        int result = 0;

        boolean isFirst = true;
        if (plusCnt % 2 == 0) {
            // 짝수인 경우
            int tmp = 0;
            while(!plus.isEmpty()) {
                Integer poll = plus.poll();

                if (poll == 1) {
                    if (!isFirst) {
                        result += tmp + 1;
                        isFirst = true;
                    } else {
                        result++;
                    }
                    continue;
                }

                if (isFirst) {
                    isFirst = false;
                    tmp = poll;
                } else {
                    isFirst = true;
                    tmp *= poll;
                    result += tmp;
                    tmp = 0;
                }
            }
        } else {
            // 홀수개 있는 경우
            int tmp = 0;
            while(!plus.isEmpty()) {
                Integer poll = plus.poll();

                if (poll == 1) {
                    if (!isFirst) {
                        result += tmp + 1;
                        isFirst = true;
                    } else {
                        result++;
                    }
                    continue;
                }

                if (plus.size() == 0) {
                    result += poll;
                    break;
                }

                if (isFirst) {
                    isFirst = false;
                    tmp = poll;
                } else {
                    isFirst = true;
                    tmp *= poll;
                    result += tmp;
                    tmp = 0;
                }
            }
        }

        // 음수도 존재하는 경우
        if (minusCnt > 0) {
            // 음수가 짝수개 존재
            isFirst = true;
            if (minusCnt % 2 == 0) {
                // 짝수인 경우
                int tmp = 0;
                while(!minus.isEmpty()) {
                    Integer poll = minus.poll();

                    if (isFirst) {
                        isFirst = false;
                        tmp = poll;
                    } else {
                        isFirst = true;
                        tmp *= poll;
                        result += tmp;
                        tmp = 0;
                    }
                }
            } else {
                // 홀수개 있는 경우
                int tmp = 0;
                while(!minus.isEmpty()) {
                    Integer poll = minus.poll();

                    if (minus.isEmpty()) {
                        // 한개 남은 경우
                        if (zeroExist) {
                            result += 0;
                        } else {
                            result += poll;
                        }

                        break;
                    }

                    if (isFirst) {
                        isFirst = false;
                        tmp = poll;
                    } else {
                        isFirst = true;
                        tmp *= poll;
                        result += tmp;
                        tmp = 0;
                    }
                }
            }
        }

        System.out.println(result);
    }
}