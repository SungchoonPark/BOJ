import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1번 풀이
public class Main {

    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 배열을 -1로 초기화
        for(int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        String a = br.readLine();
        
        for(int i=1; i<=a.length(); i++) {
            char tmpS = a.charAt(i-1);
            // 10 ~ 35 : a~z
            int num = Character.getNumericValue(tmpS);
            if(alphabet[num-10] == -1) {
                alphabet[num-10] = i-1;
            }
        }

        for (int j : alphabet) {
            System.out.printf("%s ", j);
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2번 풀이
public class Main {

    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열을 -1로 초기화
        for(int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

	// 2번 풀이의 핵심. 
        char arr[] = br.readLine().toCharArray();

        for(int i=0; i<arr.length; i++) {
           int tmp = arr[i] - 97;
           if(alphabet[tmp] == -1) {
               alphabet[tmp] = i;
           }
        }

        for (int j : alphabet) {
            System.out.printf("%s ", j);
        }

    }
}

