import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1966
*/

/*
[문제 정리]
- 2 초 / 128 MB

- 인쇄 조건
  1. 현재 queue의 가장 앞에 있는 문서의 중요도 확인
  2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 인쇄하지 않고 queue의 가장 뒤에 배치

- 중요도는 1 이상 9 이하의 정수
- 중요도가 같은 문서가 여러 개 존재할 수 있다.

- queue에 있는 문서의 수와 중요도가 주어질 때, 어떤 한 문서가 몇 번째로 인쇄되는 지 구하기
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 문서의 개수 (1 <= N <= 100)
	static int M; // 출력 순서를 알고싶은 문서의 위치 (0 <= M < N)
	
	static Queue<Integer> PRIORITY; // 각 문서의 중요도
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] input = br.readLine().split(" ");
			
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			PRIORITY = new LinkedList<>();
			map = new TreeMap<>();
			
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int elem = Integer.parseInt(input[i]);
				
				PRIORITY.add(elem);
				
				if (map.containsKey(elem)) map.replace(elem, map.get(elem) + 1);
				else map.put(elem, 1);
			}
			
			// ------------------------ input ------------------------
			
			while (true) {
				
				int paper = PRIORITY.poll();
				M--;
				
				if (map.lastKey() == paper) {
					map.replace(paper, map.get(paper) - 1);
					
					if (M < 0) break;
					
					if (map.get(paper) == 0) map.remove(paper);
				} else {
					PRIORITY.add(paper);
					
					if (M < 0) M = PRIORITY.size() - 1;
				}
				
			}
			
			sb.append(N - PRIORITY.size()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}