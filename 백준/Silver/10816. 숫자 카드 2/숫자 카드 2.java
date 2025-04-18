import java.io.*;
import java.util.*;

class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    
    static int N; // 가지고 있는 숫자 카드 수
    static int[] cards;
    
    static int M;
    static int[] searchList;
    
	public static void main(String[] args) throws Exception {
        
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        cards = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }
        
        M = Integer.parseInt(br.readLine());
        
        searchList = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            searchList[i] = Integer.parseInt(input[i]);
        }
        
        // --------------------------- input ---------------------------
        
        Arrays.sort(cards);
        
        for (int target: searchList) {
            int count = upperBound(target) - lowerBound(target);
            
            sb.append(count).append(" ");
        }
        
        System.out.println(sb);
        
	}
    
    static int lowerBound(int target) {
        
        int left = 0;
        int right = N;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (cards[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        return left;
        
    }
    
    static int upperBound(int target) {
        
        int left = 0;
        int right = N;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (cards[mid] <= target) left = mid + 1;
            else right = mid;
        }
        
        return left;
        
    }
    
}