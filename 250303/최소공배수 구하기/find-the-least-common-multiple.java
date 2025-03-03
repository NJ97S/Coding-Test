import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int MAX = Math.max(N, M);
        int MIN = Math.min(N, M);

        System.out.println(N * M / gcd(MAX, MIN));

    }

    static int gcd(int a, int b) {

        if (b == 0) return a;

        return gcd(b, a % b);

    }

}