import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    public static void main(String[] args) throws IOException {
    
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = getSum(1, 0);

        System.out.println(answer / 10);

    }

    static int getSum(int num, int sum) {

        if (num > N) return sum;

        return getSum(num + 1, sum + num);

    }

}