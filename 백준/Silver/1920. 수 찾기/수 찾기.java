import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 정수의 개수 (1 <= N <= 100,000)
	static int[] NUMBERS;
	
	static int M; // 찾아야 하는 정수의 개수
	static int[] INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		NUMBERS = new int[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			NUMBERS[i] = Integer.parseInt(input[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		INPUT = new int[M];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			INPUT[i] = Integer.parseInt(input[i]);
		}
		
		// -------------------------- NUMBERS --------------------------
		
		Arrays.sort(NUMBERS);
		
		for (int num: INPUT) {			
			sb.append(binarySearch(num)).append("\n");
		}
		
		System.out.println(sb);
		
	}

	static int binarySearch(int num) {
		
		int left = 0;
		int right = N - 1;
		
		while (left <= right) {
			
			int mid = (left + right) / 2;
			
			if (NUMBERS[mid] == num) return 1;
			else if (NUMBERS[mid] < num) left = mid + 1;
			else right = mid - 1;
			
		}
		
		return 0;
		
	}
	
}