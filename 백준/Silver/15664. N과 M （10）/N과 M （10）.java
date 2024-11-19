import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n, m;
    static Set<String> set = new HashSet<>();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combination(new ArrayList<>(), 0);

        for (String sequence : result) {
            sb.append(sequence).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void combination(List<Integer> selected, int index) {
        if (selected.size() == m) {
            StringBuilder sequence = new StringBuilder();
            for (int num : selected) {
                sequence.append(num).append(" ");
            }
            if (!set.contains(sequence.toString().trim())) {
                result.add(sequence.toString().trim());
            }
            set.add(sequence.toString().trim());
            return;
        }

        for (int i = index; i < n; i++) {
            selected.add(arr[i]);
            combination(selected, i + 1);
            selected.remove(selected.size() - 1); // 선택된 요소 제거
        }
    }
}