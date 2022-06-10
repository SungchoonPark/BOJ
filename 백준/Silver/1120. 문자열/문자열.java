import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // A의 앞 또는 뒤에만 붙일 수 있고 A와 B의 길이가 같아질 때까지 하면 됨.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        int result = 0;

        if(A.length() == B.length()) {
            for(int i=0; i<A.length(); i++) {
                if(arrA[i] != arrB[i]) {
                    result++;
                }
            }

            System.out.println(result);
        } else {
            int max = 0;
            for(int i=0; i<= B.length() - A.length(); i++) {
                int tmp=0;
                for(int j=0; j<A.length(); j++) {
                    if(arrA[j] == arrB[i+j]) {
                        tmp++;
                    }
                }
                if(tmp > max) {
                    max = tmp;
                }
            }

            System.out.println(A.length() - max);
        }
    }
}

