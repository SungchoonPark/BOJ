import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static final String GOOD = " is acceptable.";
    static final String BAD = " is not acceptable.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            String word = br.readLine();
            if (word.equals("end")) break;

            // 1. 모음 포함 여부 확인
            if (!(word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u"))) {
                sb.append("<").append(word).append(">").append(BAD).append("\n");
                continue;
            }

            boolean flag = false;
            char[] charArray = word.toCharArray();
            String vowels = "aeiou";

            // 2. 같은 글자 3번 반복 체크
            for (int i = 0; i < charArray.length - 2; i++) {
                if (charArray[i] == charArray[i + 1] && charArray[i + 1] == charArray[i + 2]) {
                    sb.append("<").append(word).append(">").append(BAD).append("\n");
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            // 3. 모음 또는 자음 3번 연속 체크
            for (int i = 0; i < charArray.length - 2; i++) {
                boolean firstVowel = vowels.indexOf(charArray[i]) != -1;
                boolean secondVowel = vowels.indexOf(charArray[i + 1]) != -1;
                boolean thirdVowel = vowels.indexOf(charArray[i + 2]) != -1;

                if ((firstVowel && secondVowel && thirdVowel) || (!firstVowel && !secondVowel && !thirdVowel)) {
                    sb.append("<").append(word).append(">").append(BAD).append("\n");
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            // 4. 같은 글자 2번 반복 체크 (단, e와 o는 허용)
            for (int i = 0; i < charArray.length - 1; i++) {
                if (charArray[i] == charArray[i + 1]) {
                    if (charArray[i] != 'e' && charArray[i] != 'o') {
                        sb.append("<").append(word).append(">").append(BAD).append("\n");
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) continue;

            // 5. 모든 조건 만족 시 GOOD
            sb.append("<").append(word).append(">").append(GOOD).append("\n");
        }

        System.out.print(sb);
    }
}