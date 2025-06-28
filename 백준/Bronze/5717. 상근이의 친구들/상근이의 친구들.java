import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static StringBuilder sb;

    static int M; // 남자 친구의 수
    static int F; // 여자 친구의 수

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");

            M = Integer.parseInt(input[0]);
            F = Integer.parseInt(input[1]);

            if (M == 0 && F == 0) break;

            sb.append(M + F).append("\n");
        }

        System.out.println(sb);

    }

}