import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
- 한 줄에 입력받는 요소의 수가 2개 -> 연산 1: 최대힙에 요소 추가
- 한 줄에 입력받는 요소의 수가 1개 -> 연산 2: 루트 노드 키 값 출력 후, 해당 노드 삭제
*/

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; //수행해야 하는 연산의 수
	
	static List<Integer> maxHeap;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);
			
			maxHeap = new ArrayList<>();
			maxHeap.add(null);
			
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) { // N번만큼 반복
				String[] input = br.readLine().split(" ");
				
				// 연산 1: 최대힙에 요소 추가
				if (input.length == 2) {
					maxHeap.add(Integer.parseInt(input[1]));
					
					shiftUp(maxHeap.size() - 1);
				}
				
				// 연산 2: 루트 노드 키 값 출력 후, 해당 노드 삭제
				else {
					if (maxHeap.size() == 1) sb.append(" ").append(-1); // 힙이 비어있을 경우, -1 출력
					
					else {
						sb.append(" ").append(maxHeap.get(1));
						
						maxHeap.set(1, maxHeap.get(maxHeap.size() - 1));
						maxHeap.remove(maxHeap.size() - 1);
						
						shiftDown(1);						
					} 
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void shiftUp(int leaf) {
		if (maxHeap.size() <= 1) return;
		
		if (leaf < 2) return;
		
		if (maxHeap.get(leaf) > maxHeap.get(leaf / 2)) {
			int temp = maxHeap.get(leaf);
			maxHeap.set(leaf, maxHeap.get(leaf / 2));
			maxHeap.set(leaf / 2, temp);
			
			shiftUp(leaf / 2);
		}
	}
	
	static void shiftDown(int root) {
		if (maxHeap.size() <= 1) return;
		
		if (root >= maxHeap.size() / 2) return;
		
		int child = root * 2;
		if (root * 2 + 1 <= maxHeap.size() && maxHeap.get(root * 2 + 1) > maxHeap.get(child)) child++;
		
		if (maxHeap.get(child) > maxHeap.get(root)) {
			int temp = maxHeap.get(child);
			maxHeap.set(child, maxHeap.get(root));
			maxHeap.set(root, temp);
			
			shiftDown(child);
		}
	}
	
}