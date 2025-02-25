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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(1);
            }
            System.out.println();
        }

    }

}