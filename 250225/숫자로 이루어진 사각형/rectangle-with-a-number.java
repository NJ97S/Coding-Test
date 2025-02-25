import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(num++ + " ");

                if (num > 9) num = 1;
            }
            System.out.println();
        }

    }

}