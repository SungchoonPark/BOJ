import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        LocalDate localDate = LocalDate.of(2007, month, day);

        int value = localDate.getDayOfWeek().getValue();
        switch (value) {
            case 1 -> System.out.println("MON");
            case 2 -> System.out.println("TUE");
            case 3 -> System.out.println("WED");
            case 4 -> System.out.println("THU");
            case 5 -> System.out.println("FRI");
            case 6 -> System.out.println("SAT");
            case 7 -> System.out.println("SUN");
            default -> System.out.println("-1");
        }
    }
}