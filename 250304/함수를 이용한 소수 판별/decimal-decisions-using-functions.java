import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int A;
    static int B;

    static int answer;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        answer = 0;

        for (int i = A; i <= B; i++) {
            if (isPrime(i)) answer += i;
        }

        System.out.println(answer);

    }

    static boolean isPrime (int num) {

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;

    }

}