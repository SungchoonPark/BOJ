import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // solution 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i=2; i*i <= num; i++) {
            while(num%i == 0) {
                sb.append(i).append('\n');
                num /= i;
            }
        }

        if (num != 1) {
            sb.append(num);
        }

        System.out.println(sb);
        
        // solution 2
        // 에라토스테네스의 채 사용 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int tmp = num;

        if(num == 1) {
            return;
        }

        boolean[] arr = new boolean[num + 1];
        arr[0] = true;
        arr[1] = true;
        // 에라토스테네스의 채
        for (int i = 2; i * i < num + 1; i++) {
            for (int j = i * i; j < num + 1; j += i) {
                arr[j] = true;
            }
        }

        List<Integer> prime = new ArrayList<>();
        for(int i=2; i<num+1; i++) {
            if (!arr[i]) {
                prime.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(true) {
            if(tmp % prime.get(i) == 0) {
                //일단 나눠진다는 것
                if(tmp / prime.get(i) == 1) {
                    // 소인수 분해 끝난것
                    result.add(prime.get(i));
                    break;
                } else {
                    tmp /= prime.get(i);
                    result.add(prime.get(i));
                    i=0;
                }
            } else {
                i++;
            }

        }

        for(int j=0; j<result.size(); j++) {
            if(j == result.size()-1) {
                sb.append(result.get(j));
            } else {
                sb.append(result.get(j)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

