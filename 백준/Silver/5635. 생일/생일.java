import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Person> people = new PriorityQueue<>((p1, p2) -> p2.localDate.compareTo(p1.localDate));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            people.add(new Person(name, year, month, day));
        }

        int cnt = 1;
        while(!people.isEmpty()) {
            Person person = people.poll();
            if (cnt == 1 || cnt == n) {
                System.out.println(person.name);
            }
            cnt++;
        }
    }

    static class Person {
        String name;
        LocalDate localDate;

        public Person(String name, int year, int month, int day) {
            this.name = name;
            this.localDate = LocalDate.of(year, month, day);
        }
    }


}