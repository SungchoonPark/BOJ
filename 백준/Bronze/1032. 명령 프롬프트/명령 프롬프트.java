import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<String> stringList = new ArrayList<>();
        List<Integer> diffIdx = new ArrayList<>();

        for(int i=0; i<num; i++) {
            stringList.add(br.readLine());
        }
        int stringSize = stringList.get(0).length();

        if(stringList.size() == 1) {
            // 단어가 하나만 들어온 경우
            System.out.println(stringList.get(0));
        } else {
            // 단어가 두개 이상 들어온 경우
            for(int i=1; i<stringList.size(); i++) {
                char[] charArr1 = stringList.get(i).toCharArray();
                char[] charArr2 = stringList.get(i-1).toCharArray();

                for(int j=0; j<stringSize; j++) {
                    if(charArr1[j] != charArr2[j]) {
                        diffIdx.add(j);
                    }
                }
            }

            char[] str = stringList.get(0).toCharArray();
            for(int i=0; i<diffIdx.size(); i++) {
                int a = diffIdx.get(i);
                str[a] = '?';
            }
            StringBuilder sb = new StringBuilder();
            for(char a : str) {
                sb.append(a);
            }
            System.out.println(sb);

        }
    }
}

