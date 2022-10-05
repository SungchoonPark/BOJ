import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String content = br.readLine();
        String findWord = br.readLine();

        int tmp = content.length();
        content = content.replace(findWord, "");
        
        int tmp2 = content.length();
        System.out.println((tmp - tmp2) / findWord.length());
    }
}