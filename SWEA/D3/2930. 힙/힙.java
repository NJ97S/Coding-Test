import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	static List<Integer> tree;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {		
			sb = new StringBuilder();
			
			N = Integer.valueOf(br.readLine()); // 연산의 수
			
			tree = new ArrayList<>();
			tree.add(null); // 0번 인덱스 만들기
			
			// 1차원 배열로 트리 만들기
			for (int i = 1; i <= N; i++) {
				String[] input = br.readLine().split(" ");
				
				if (input.length == 2) {
					int value = Integer.valueOf(input[1]);
					
					tree.add(value);
					
					shiftUp(tree.size() - 1, value);
				}
				
				else {
					if (tree.size() == 1) sb.append(-1 + " ");
					
					else {
						sb.append(tree.get(1) + " "); // 최댓값 출력
						
						tree.set(1, tree.get(tree.size() - 1)); // 마지막 요소 -> 첫 번째 요소
						tree.remove(tree.size() - 1); // 마지막 요소 삭제
						
						if (tree.size() == 1) continue;
						
						shiftDown(1, tree.get(1));
					}
				}
			}
			
			System.out.printf("#%d %s\n", testCase, sb.toString().trim());
		}
		
	}
	
	static void shiftUp(int idx, int value) {
		if (tree.size() == 2) return;
		
		// value > 부모노드 값 => swap
		while (idx >= 2 && tree.get(idx) > tree.get(idx / 2)) {
			int temp = tree.get(idx);
			tree.set(idx, tree.get(idx / 2));
			tree.set(idx / 2, temp);
			
			idx = idx / 2;
		}
	}
	
	static void shiftDown(int idx, int value) {
		if (tree.size() == 2) return;
		
		// 왼쪽 자식 노드와 오른쪽 자식 노드 중 더 큰 값으로 설정
		int childIdx = idx * 2;
		if (childIdx + 1 < tree.size() && tree.get(childIdx + 1) > tree.get(childIdx)) childIdx++;
		
		// value < 자식노드 값 => swap
		while (childIdx < tree.size() && tree.get(idx) < tree.get(childIdx)) {
			int temp = tree.get(idx);
			tree.set(idx, tree.get(childIdx));
			tree.set(childIdx, temp);
			
			idx = childIdx;
			childIdx *= 2;
			
			if (childIdx + 1 < tree.size() && tree.get(childIdx + 1) > tree.get(childIdx)) childIdx++;
		}
	}
	
}