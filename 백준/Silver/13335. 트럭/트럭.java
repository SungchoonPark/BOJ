import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < n; i++) {
            int truck = arr[i];

            while(true) {
                if (queue.size() == w) {
                    bridgeWeight -= queue.poll();
                }

                if (bridgeWeight + truck <= l) {
                    queue.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                } else {
                    queue.add(0);
                    time++;
                }
            }
        }
        time += w;

        System.out.println(time);
    }
}