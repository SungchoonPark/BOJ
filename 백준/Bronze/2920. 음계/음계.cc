import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 풀이 1
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int flag = 1;
        if(list.get(0) == 1) {
            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i+1)-list.get(i) != 1) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("mixed");
            } else System.out.println("ascending");
        } else if(list.get(0) == 8) {
            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i)-list.get(i+1) != 1) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("mixed");
            } else System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

        br.close();
    }
}

// 풀이 2 
// 매우 간단한 방법 (왜 이걸 생각못했을까;;)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String list = br.readLine();

        String ascending = "1 2 3 4 5 6 7 8";
        String descending = "8 7 6 5 4 3 2 1";

        if(list.equals(ascending)){
            System.out.println("ascending");
        } else if(list.equals(descending)) {
            System.out.println("descending");
        } else
            System.out.println("mixed");

        br.close();
    }
}

