import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        char[] arr = word.toCharArray();
        char[] save = arr.clone();
        char[] tmp = arr.clone();
        List<String> result = new ArrayList<>();

        Arrays.sort(arr);

        for (char c : arr) {
            String s = "";
            for(int i=0; i<arr.length; i++) {
                if(c == save[i] && tmp[i] >=97 && tmp[i] <= 122) {
                    tmp[i] -= 32;
                    for(int j=i; j<arr.length; j++) {
                        s += save[j];
                    }
                    break;
                }
            }
            result.add(s);
        }

        Collections.sort(result);
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
