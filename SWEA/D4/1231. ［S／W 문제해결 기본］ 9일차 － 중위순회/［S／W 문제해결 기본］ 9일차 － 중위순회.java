import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			final int N = sc.nextInt(); // 트리가 갖는 정점의 총 수
			sc.nextLine();
			
			final char[] TREE = new char[N + 1];
			
			for (int i = 1; i <= N; i++) {
				String line = sc.nextLine();
				String[] lineArr = line.split(" ");
				
				TREE[i] = lineArr[1].charAt(0);
			}
			
			StringBuilder sb = new StringBuilder();
			
			inOrder(TREE, 1, sb);
			
			System.out.printf("#%d %s\n", testCase, sb.toString());
		}
		
		sc.close();

	}
	
	static StringBuilder inOrder(char[] tree, int root, StringBuilder sb) {
		if (root >= tree.length || tree[root] == 0) return sb;
		
		inOrder(tree, root * 2, sb);
		
		sb.append(tree[root]);
		
		inOrder(tree, root * 2 + 1, sb);
		
		return sb;
	}

}
