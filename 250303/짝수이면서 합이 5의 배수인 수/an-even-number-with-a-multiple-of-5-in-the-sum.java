import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N % 2 == 0 && getSum(N, 0) % 5 == 0) {
            System.out.println("Yes");
            return;
        }
            
        System.out.println("No");

    }

    static int getSum (int num, int sum) {

        if (num == 0) return sum;

        return getSum(num / 10, sum + (num % 10));

    }

}