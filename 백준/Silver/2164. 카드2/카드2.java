import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 카드의 개수 (1 <= N <= 500,000)
	
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		removeCard();
		
		System.out.println(list.get(0));
		
	}
	
	static void removeCard() {
		
		if (list.size() == 1) return;
		
		list.remove(0);
		list.add(list.remove(0));
		
		removeCard();
		
	}
	
}