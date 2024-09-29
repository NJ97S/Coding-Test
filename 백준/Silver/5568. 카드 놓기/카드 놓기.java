import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 카드의 개수 (4 <= N <= 10)
	static int K; // 선택할 카드의 개수 (2 <= K <= 4)
	
	static int[] CARDS;
	
	static int[] selectedCards;
	
	static Set<String> numbers; // 만들어진 숫자
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		CARDS = new int[N];
		
		for (int i = 0; i < N; i++) {
			CARDS[i] = Integer.parseInt(br.readLine());
		}
		
		// --------------------- input ---------------------
		
		Arrays.sort(CARDS);
		
		selectedCards = new int[K];
		numbers = new HashSet<>();
		
		makeNumber(0, 0);
		
		System.out.println(numbers.size());
		
	}
	
	
	// idx: selectedCards 배열의 인덱스
	// count: 선택한 카드의 수
	static void makeNumber(int idx, int visited) {
		
		// 기저 조건
		if (idx == K) {		
			convertNum();
			
			return;
		}
		
		// 재귀 부분
		int prev = -1;
		
		for (int i = 0; i < N; i++) {
			
			if ((visited & (1 << i)) != 0 || prev == CARDS[i]) continue;
			
			prev = CARDS[i];
			
			selectedCards[idx] = CARDS[i];
			makeNumber(idx + 1, visited | 1 << i);
			
		}
		
	}
	
	static void convertNum() {
		
		sb = new StringBuilder();
		
		for (int elem: selectedCards) {
			sb.append(elem);
		}
		
		numbers.add(sb.toString());
		
	}
	
}