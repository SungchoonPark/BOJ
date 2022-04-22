import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        char[] arr = word.toCharArray();

        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if(i == word.length()-1) {
                cnt++;
                break;
            }
            if (arr[i] == 'c') {
                if (arr[i + 1] == '=') {
                    cnt++;
                    ++i;
                } else if (arr[i + 1] == '-') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }
            } else if (arr[i] == 'd') {
                if (arr[i + 1] == 'z') {
                    if (i + 1 == word.length()-1) {
                        cnt += 2;
                        break;
                    }
                    if (arr[i + 2] == '=') {
                        cnt++;
                        i += 2;
                    } else {
                        cnt++;
                    }
                } else if (arr[i + 1] == '-') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }
            } else if (arr[i] == 'l') {
                if (arr[i + 1] == 'j') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }

            } else if (arr[i] == 'n') {
                if (arr[i + 1] == 'j') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }

            } else if (arr[i] == 's') {
                if (arr[i + 1] == '=') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }

            } else if (arr[i] == 'z') {
                if (arr[i + 1] == '=') {
                    cnt++;
                    ++i;
                } else {
                    cnt++;
                }

            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

