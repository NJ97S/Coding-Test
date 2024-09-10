import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int M; // 수행해야 하는 연산의 수
	
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		M = Integer.parseInt(br.readLine());
		
		list = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			
			if (input[0].equals("add")) {
				int num = Integer.parseInt(input[1]);
				
				if (list.indexOf(num) != -1) continue;
				
				list.add(num);
			}
			
			else if (input[0].equals("remove")) {
				int num = Integer.parseInt(input[1]);
				int idx = list.indexOf(num);
				
				if (idx == -1) continue;
				
				list.remove(idx);
			}
			
			else if (input[0].equals("check")) {
				int num = Integer.parseInt(input[1]);
				
				sb.append(list.indexOf(num) != -1 ? 1 : 0).append("\n");
			}
			
			else if (input[0].equals("toggle")) {
				int num = Integer.parseInt(input[1]);
				int idx = list.indexOf(num);
				
				if (idx != -1) list.remove(idx);
				else list.add(num);
			}
			
			else if (input[0].equals("all")) {
				list.removeAll(list);
				
				for (int k = 1; k <= 20; k++) {
					list.add(k);
				}
			}
			
			else {
				list.removeAll(list);
			}
		}
		
		System.out.println(sb);
		
	}
	
}