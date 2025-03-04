import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int A;
    static int B;

    static int count;

    public static void main(String[] args) throws IOException {
    
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        count = 0;

        for (int i = A; i <= B; i++) {
            if (isTrue(i) || i % 3 == 0) count++;
        }

        System.out.println(count);

    }

    // 숫자에 3, 6, 9 중 하나라도 포함되어 있는 지에 대한 유무 판단
    static boolean isTrue (int num) {

        if (num == 0) return false;

        if ((num % 10) % 3 == 0) return true;

        return isTrue(num / 10);

    }

}