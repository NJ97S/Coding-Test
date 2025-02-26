import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // --------------------- input ---------------------

        int maxNum = Math.max(N, M);

        for (int i = maxNum; i > 0; i--) {
            if (N % i != 0 || M % i != 0) continue;

            System.out.println(i);
            break;
        }

    }

}