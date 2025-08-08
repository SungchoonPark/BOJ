import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int[] counts = new int[5];
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int value = Integer.parseInt(st.nextToken());
                counts[value]++;
            }

            CardInfo a = new CardInfo(counts);

            st = new StringTokenizer(br.readLine());

            counts = new int[5];
            num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int value = Integer.parseInt(st.nextToken());
                counts[value]++;
            }

            CardInfo b = new CardInfo(counts);

            if (a.star > b.star) {
                sb.append("A").append("\n");
            } else if (a.star < b.star) {
                sb.append("B").append("\n");
            } else {
                if (a.rec > b.rec) {
                    sb.append("A").append("\n");
                } else if (a.rec < b.rec) {
                    sb.append("B").append("\n");
                } else {
                    if (a.square > b.square) {
                        sb.append("A").append("\n");
                    } else if (a.square < b.square) {
                        sb.append("B").append("\n");
                    } else {
                        if (a.tri > b.tri) {
                            sb.append("A").append("\n");
                        } else if (a.tri < b.tri) {
                            sb.append("B").append("\n");
                        } else {
                            sb.append("D").append("\n");
                        }
                    }
                }
            }

        }
        System.out.print(sb);
    }

    static class CardInfo {
        int star;
        int rec;
        int square;
        int tri;

        public CardInfo(int[] counts) {
            this.star = counts[4];
            this.rec = counts[3];
            this.square = counts[2];
            this.tri = counts[1];
        }

        @Override
        public String toString() {
            return "CardInfo{" +
                "star=" + star +
                ", rec=" + rec +
                ", square=" + square +
                ", tri=" + tri +
                '}';
        }
    }

}