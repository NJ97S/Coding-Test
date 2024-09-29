import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 카드의 개수 (4 <= N <= 10)
	static int K; // 선택할 카드의 개수 (2 <= K <= 4)
	
	static int[] CARDS;
	
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
		
		numbers = new HashSet<>();
		
		String number = "";
		
		makeNumber(0, 0, number);
		
		System.out.println(numbers.size());
		
	}
	
	static void makeNumber(int visited, int count, String number) {
		
		// 기저 조건
		if (count == K) {			
			numbers.add(number);
			
			return;
		}
		
		// 재귀 부분
		int prev = -1;
		
		for (int i = 0; i < N; i++) {
			
			if ((visited & (1 << i)) != 0 || prev == CARDS[i]) continue;
			
			prev = CARDS[i];
			
			makeNumber(visited | 1 << i, count + 1, number + CARDS[i]);
			
		}
		
	}
	
}