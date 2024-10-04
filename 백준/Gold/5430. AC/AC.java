import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
[문제 링크]
- https://www.acmicpc.net/problem/5430
*/

/*
[문제 정리]
- 1 초 / 256 MB

- R(배열에 있는 수의 순서 뒤집기) 또는 D(첫 번째 수 버리기) 수행 가능
  - 배열이 비어있을 때 D를 사용하면, 에러 발생

- 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과 구하기
*/

/*
[풀이 방식]
- D의 개수가 N보다 클 경우 -> error

- 순서가 정방향인지 역방향인지를 boolean 값으로 저장
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static String COMMAND; // 수행할 함수
	
	static int N; // 수의 개수

	static Deque<Integer> numbers;
	
	static int countOfD; // D의 수
	
	static boolean isReverse; // 순서 역방향이면 true
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		caseLoop:
		for (int testCase = 1; testCase <= T; testCase++) {
			COMMAND = br.readLine();
			
			N = Integer.parseInt(br.readLine());
			
			numbers = new LinkedList<>();
			
			String[] input = br.readLine().split(",|\\[|\\]");
			
			for (int i = 1; i <= N; i++) {
				numbers.add(Integer.parseInt(input[i]));
			}
			
			// ---------------------- input ----------------------
			
			countOfD = 0;
			isReverse = false;
			
			for (int i = 0; i < COMMAND.length(); i++) {
				char comm = COMMAND.charAt(i);
				
				if (comm == 'R') isReverse = !isReverse;
				
				else if (comm == 'D') {
					countOfD++;
					
					if (countOfD > N) { // D 명령어의 수가 N을 넘어가면, error 출력하고 종료
						sb.append("error").append("\n");
						continue caseLoop;
					}
					
					if (isReverse) numbers.pollLast();
					else numbers.pollFirst();
				}
			}
			
			sb.append("[");
			
			while (numbers.size() > 1) {
				if (isReverse) sb.append(numbers.pollLast()).append(",");
				else sb.append(numbers.pollFirst()).append(",");
			}
			
			sb.append(numbers.isEmpty() ? "" : numbers.poll()).append("]").append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}