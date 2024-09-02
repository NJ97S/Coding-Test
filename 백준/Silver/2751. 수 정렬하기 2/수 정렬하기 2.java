import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 수의 개수
	
	static int[] INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		INPUT = new int[N];
		
		for (int i = 0; i < N; i++) {
			INPUT[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(INPUT);
		
		for (int elem: INPUT) {
			sb.append(elem).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}