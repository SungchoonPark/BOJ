import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // A의 앞 또는 뒤에만 붙일 수 있고 A와 B의 길이가 같아질 때까지 하면 됨.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        Student[] list = new Student[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list[i] = new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        Comparator<Student> newComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.kscore < o2.kscore) {
                    return 1;
                } else if (o1.kscore == o2.kscore) {
                    if (o1.escore > o2.escore) {
                        return 1;
                    } else if (o1.escore == o2.escore) {
                        if (o1.mscore < o2.mscore) {
                            return 1;
                        } else if (o1.mscore == o2.mscore) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
            }
        };

        Arrays.sort(list, newComparator);
        for (Student student : list) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }
}

class Student {
    String name;
    int kscore;
    int escore;
    int mscore;

    public Student(String name, int kscore, int escore, int mscore) {
        this.name = name;
        this.kscore = kscore;
        this.escore = escore;
        this.mscore = mscore;
    }
}
