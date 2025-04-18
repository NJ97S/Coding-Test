import java.io.*;
import java.util.*;

class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    
    static int N;
    static int[] list;
    
    static int M;
    static int[] numbers;
    
	public static void main(String[] args) throws Exception {
        
		br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
		
        N = Integer.parseInt(br.readLine());
        
        list = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(input[i]);
        }
        
        M = Integer.parseInt(br.readLine());
        
        numbers = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        
        // ---------------------- input ----------------------
        
        Arrays.sort(list);
        
        for (int i = 0; i < M; i++) {
            boolean haveNumber = binarySearch(0, N - 1, numbers[i]);
            sb.append(haveNumber ? 1 : 0).append("\n");
        }
        
        System.out.println(sb);
        
	}
    
    static boolean binarySearch(int left, int right, int target) {
        
        if (left > right) return false;
        
        int mid = (left + right) / 2;
        
        if (list[mid] == target) return true;
        
        if (list[mid] > target) return binarySearch(left, mid - 1, target);
        else if (list[mid] < target) return binarySearch(mid + 1, right, target);
        
        return false;
    }
    
}