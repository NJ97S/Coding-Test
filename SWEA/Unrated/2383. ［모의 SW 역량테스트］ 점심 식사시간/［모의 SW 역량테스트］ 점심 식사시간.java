import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 방의 크기 (4 <= N <= 10)
	
	static int[][] MAP;
	
	static int[][] ENTRY; // 계단 입구 좌표
	static List<int[]> PERSON; // 사람 좌표
	
	static boolean[] selected; // 선택된 사람 -> 0번 계단
	
	static int answer; // 이동 완료하는 최소 시간
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			MAP = new int[N][N];
			
			ENTRY = new int[2][];
			int eIdx = 0;
			
			PERSON = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				
				for (int j = 0; j < N; j++) {
					int elem = Integer.parseInt(input[j]);
					
					MAP[i][j] = elem;
					
					if (elem > 1) ENTRY[eIdx++] = new int[] {i, j};
					else if (elem == 1) PERSON.add(new int[] {i, j});
				}
			}
			
			// ------------------------ input ------------------------
			
			answer = Integer.MAX_VALUE;
			
			selected = new boolean[PERSON.size()];
			selectPerson(0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// idx: selected 배열의 인덱스
	static void selectPerson(int idx) {
		
		if (idx >= selected.length) {		
			answer = Math.min(answer, getTime());
			
			return;
		}
		
		selected[idx] = true;
		selectPerson(idx + 1);
		
		selected[idx] = false;
		selectPerson(idx + 1);
		
	}
	
	static int getTime() {
		
		List<Integer> time1 = new ArrayList<>();
		List<Integer> time2 = new ArrayList<>();
		
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) time1.add(Math.abs(ENTRY[0][0] - PERSON.get(i)[0]) + Math.abs(ENTRY[0][1] - PERSON.get(i)[1]) + 1 + MAP[ENTRY[0][0]][ENTRY[0][1]]);
			else time2.add(Math.abs(ENTRY[1][0] - PERSON.get(i)[0]) + Math.abs(ENTRY[1][1] - PERSON.get(i)[1]) + 1 + MAP[ENTRY[1][0]][ENTRY[1][1]]);
		}
		
		Collections.sort(time1);
		Collections.sort(time2);
		
		return Math.max(decreaseTime(time1, 0), decreaseTime(time2, 1));
		
	}
	
	static int decreaseTime(List<Integer> time, int eIdx) {
		
		int result = 0;
		
		while (!time.isEmpty()) {			
			result++;
			
			for (int i = 0; i < time.size(); i++) {				
				if (i >= 3 && time.get(i) <= MAP[ENTRY[eIdx][0]][ENTRY[eIdx][1]]) continue;
				
				time.set(i, time.get(i) - 1);
			}
			
			while (!time.isEmpty() && time.get(0) <= 0) {
				time.remove(0);
			}
		}
		
		return result;
		
	}
	
}