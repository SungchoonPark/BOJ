import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<num; i++) {
            set.add(br.readLine());
        }

        set.stream()
                .sorted((s1, s2) -> {
                    int len1 = s1.length();
                    int len2 = s2.length();

                    if (len1 == len2) return s1.compareTo(s2);
                    return len1 - len2;
                }).forEach(s -> System.out.println(s));
    }
}
