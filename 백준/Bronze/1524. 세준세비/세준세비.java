import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 세준이 병사 수
	static int M; // 세비 병사 수
	
	static int[] SEJUN; // 세준이 병사들의 힘
	static int[] SEBI; // 세비 병사들의 힘
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine();
			
			String[] input = br.readLine().split(" ");
			
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			SEJUN = new int[N];
			int idxOfSejun = 0;
			
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				SEJUN[i] = Integer.parseInt(input[i]);
			}
			
			SEBI = new int[M];
			int idxOfSebi = 0;
			
			input = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				SEBI[i] = Integer.parseInt(input[i]);
			}
			
			// ----------------------- input -----------------------
			
			Arrays.sort(SEJUN);
			Arrays.sort(SEBI);
			
			while (idxOfSejun < N && idxOfSebi < M) {
				
				if (SEJUN[idxOfSejun] >= SEBI[idxOfSebi]) idxOfSebi++;
				else idxOfSejun++;
				
			}
			
			sb.append(idxOfSebi == M ? "S" : "B").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}