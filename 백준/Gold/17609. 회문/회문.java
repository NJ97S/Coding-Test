import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/17609
*/

/*
[문제 정리]
- 1 초 / 512 MB

- 유사회문 = 한 문자를 삭제하여 회문으로 만들 수 있는 문자열

- 제시된 문자열이 회문이면 0, 유사회문이면 1, 일반 문자열이면 2 출력
*/

/*
[풀이 방식]
1. 회문 판단
   - (N / 2)번 반복문 돌리기
   - 0번 인덱스와 (N - 1)번 인덱스 비교, 1번 인덱스와 (N - 2)번 인덱스 비교, ...

2. 유사회문 판단
   - 0번 인덱스 값을 left, 마지막 인덱스 값을 right로 놓고, left와 right가 같은 지를 확인
   - 같지 않다면, right = right - 1
   - left <= right 조건일 때 반복 수행
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static String INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			INPUT = br.readLine();
			
			int left = 0;
			int right = INPUT.length() - 1;
			
			int count1 = 0;
			
			while (left <= right) {
				if (INPUT.charAt(left) == INPUT.charAt(right)) {
					left++;
					right--;
				} else {
					left++;
					count1++;
				}
			}
			
			int count2 = 0;
			
			left = 0;
			right = INPUT.length() - 1;
			
			while (left <= right) {
				if (INPUT.charAt(left) == INPUT.charAt(right)) {
					left++;
					right--;
				} else {
					right--;
					count2++;
				}
			}
			
			int count = Math.min(count1, count2);
			
			if (count == 0) sb.append(0).append("\n");
			else if (count == 1) sb.append(1).append("\n");
			else sb.append(2).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}