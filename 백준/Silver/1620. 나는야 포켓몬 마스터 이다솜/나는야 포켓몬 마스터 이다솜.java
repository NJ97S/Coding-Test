import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 포켓몬 수 (1 <= N, M <= 10^5)
	static int M; // 문제 개수
	
	static String[] book; // 도감
	static Map<String, Integer> reverseBook;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		book = new String[N + 1];
		reverseBook = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			
			book[i] = pokemon;
			reverseBook.put(pokemon, i);
		}
		
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			char first = question.charAt(0);
			
			if (first >= 'A' && first <= 'z') sb.append(reverseBook.get(question)).append("\n");
			else sb.append(book[Integer.parseInt(question)]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}