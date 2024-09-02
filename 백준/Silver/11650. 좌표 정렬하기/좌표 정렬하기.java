import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 점의 개수 (1 <= N <= 100,000)
	
	static int[][] INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		INPUT = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			INPUT[i][0] = Integer.parseInt(input[0]);
			INPUT[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(INPUT, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		
		for (int[] arr: INPUT) {
			for (int elem: arr) {
				sb.append(elem).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}