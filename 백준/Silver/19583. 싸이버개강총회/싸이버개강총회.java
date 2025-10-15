import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static LocalTime startTime;
    static LocalTime endTime;
    static LocalTime streamingEndTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        // 개강총회 시작 전에 대화 + 개강총회 시작 시간과 같은 시간에 보내면 -> 입장
        // [개강총회 끝 ~ 스트리밍 끝] 사이에 같은 시간에 보내면 -> 퇴장
        // 그래서 입장과 퇴장까지 확인된 유저는 총 몇명인가?
        for (int i = 0; i < 3; i++) {
            String time = st.nextToken();
            if (i == 0) {
                startTime = getLT(time);
            } else if (i == 1) {
                endTime = getLT(time);
            } else {
                streamingEndTime = getLT(time);
            }
        }

        Set<String> enterUsers = new HashSet<>();
        Set<String> outUsers = new HashSet<>();

        String timeInfo;
        while (true) {
            timeInfo = br.readLine();
            if (timeInfo == null || timeInfo.trim().isEmpty()) break;
            st = new StringTokenizer(timeInfo);

            LocalTime userTime = getLT(st.nextToken());
            String username = st.nextToken();

            // 입장이냐?
            if (isEnter(userTime)) {
                enterUsers.add(username);
                continue;
            }

            // 퇴장인가?
            if (isOut(userTime) && enterUsers.contains(username)) {
                outUsers.add(username);
            }
        }

        System.out.println(outUsers.size());
    }

    private static LocalTime getLT(String time) {
        StringTokenizer tokens = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(tokens.nextToken());
        int minute = Integer.parseInt(tokens.nextToken());
        return LocalTime.of(hour, minute);
    }

    private static boolean isEnter(LocalTime userEnterTime) {
        if (startTime.isAfter(userEnterTime) || startTime.equals(userEnterTime)) {
            return true;
        }

        return false;
    }

    private static boolean isOut(LocalTime userOutTime) {
        if (endTime.equals(userOutTime) ||endTime.isBefore(userOutTime) && (streamingEndTime.isAfter(userOutTime) || streamingEndTime.equals(userOutTime))) {
            return true;
        }

        return false;
    }
}