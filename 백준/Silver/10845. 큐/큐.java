import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 명령의 수
	
	static Deque<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			if (input[0].equals("push")) queue.add(Integer.parseInt(input[1]));
			else if (input[0].equals("pop")) sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
			else if (input[0].equals("size")) sb.append(queue.size()).append("\n");
			else if (input[0].equals("empty")) sb.append(queue.isEmpty() ? 1 : 0).append("\n");
			else if (input[0].equals("front")) sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
			else if (input[0].equals("back")) sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}