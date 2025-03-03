import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        int min = Math.min(A, Math.min(B, C));

        System.out.println(min);

    }

}