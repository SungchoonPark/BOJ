import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 일단 약수를 구한다음에 어디에 저장해놓고 약수들을 다 더해서 ㄱㄱ
        while(true) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            if(num == -1) break;

            int tmp = (int)Math.sqrt(num);
            for(int i=1; i<= tmp; i++) {
                if(num % i == 0) {
                    list.add(i);
                    sum += i;
                    if(num/i != i && num/i != num) {
                        list.add(num/i);
                        sum += (num/i);
                    }
                }
            }

            list.sort(Comparator.naturalOrder());

            if(num == sum) {
                StringBuilder sb = new StringBuilder();
                sb.append(num).append(' ').append("=").append(' ');
                for(int i=0; i<list.size(); i++) {
                    if(i == list.size()-1) {
                        sb.append(list.get(i));
                        break;
                    }
                    sb.append(list.get(i)).append(' ').append('+').append(' ');
                }
                System.out.println(sb);
            } else {
                System.out.println(num + " is NOT perfect.");
            }


        }
    }
}

