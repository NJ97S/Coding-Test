import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 정점의 개수 (1 <= N <= 1,000)
	static int M; // 간선의 개수 (0 <= M <= N*(N-1)/2)
	
	static boolean[] isLinked;
	
	static int[][] adjArr; // 인접행렬
	
	static int numOfConnnectedComponent; // 연결 요소의 개수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		isLinked = new boolean[N + 1];
		adjArr = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			isLinked[a] = isLinked[b] = true;
			
			adjArr[a][b] = adjArr[b][a] = 1;
		}
		
		// ----------------------- input -----------------------
		
		numOfConnnectedComponent = 0;
		
		addAlone();
		
		for (int i = 1; i <= N; i++) {			
			for (int j = 1; j <= N; j++) {
				
				if (adjArr[i][j] != 1) continue;
				
				adjArr[i][j] = adjArr[i][j] = 0;				
				getConnectedComponent(j);
				
				numOfConnnectedComponent++;

			}
		}
		
		System.out.println(numOfConnnectedComponent);
		
	}
	
	static void addAlone() {
		
		for (int i = 1; i <= N; i++) {
			if (!isLinked[i]) numOfConnnectedComponent++;
		}
		
	}
	
	static void getConnectedComponent(int r) {
		
		// 기저 조건
		if (r > N) return;
		
		// 재귀 부분
		for (int j = 1; j <= N; j++) {
			if (adjArr[r][j] != 1) continue;
			
			adjArr[r][j] = adjArr[j][r] = 0;
			getConnectedComponent(j);
		}
		
	}
	
}