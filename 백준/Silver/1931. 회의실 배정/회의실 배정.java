import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1931
*/

/*
[문제 정리]
- 2 초 / 128 MB

- 1개의 회의실을 사용하고자 하는 N개의 회의가 주어진다.
- 각 회의가 겹치지 않게 회의실을 사용할 수 있는 회의의 최대 개수 출력

- 회의는 한 번 시작하면 중간에 중단될 수 없다.
- 한 회의가 끝남과 동시에 다음 회의를 시작할 수 있다.

- 회의의 시작 시간과 종료 시간이 같을 수 있다. = 시작하자마자 끝나는 것으로 간주
*/

/*
[풀이 방식]
- list 오름차순으로 정렬
  - 시작 시간 빠른 순
  - 시작 시간이 같다면, 종료 시간 빠른 순

- prevFront, prevEnd, currFront, currEnd

- currFront <= prevEnd
  1. currEnd < prevEnd => 회의실 배정
  2. currEnd > prevEnd

- currFront < prevEnd
  => 회의실 배정
  => count++
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 회의 수 (1 <= N <= 100,000)
	
	static List<int[]> MEETINGS; // 각 회의의 시작 시간 및 종료 시간 (0 <= 시간 < 2^31)
	
	static int maxNumOfMeeting; // 최대 회의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		MEETINGS = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			MEETINGS.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
		}
		
		// ------------------------- input -------------------------
		
		Collections.sort(MEETINGS, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
				
			}
		});
		
		maxNumOfMeeting = 1;
		
		assignMeeting();
		
		System.out.println(maxNumOfMeeting);
		
	}
	
	static void assignMeeting() {
		
		int[] prevMeeting = MEETINGS.get(0); // 배정된 회의
		
		for (int i = 1; i < N; i++) {
			
			int[] currMeeting = MEETINGS.get(i);
			
			// 시작 시간이 배정된 회의 종료 시간보다 같거나 크면 => 회의실 배정 및 카운트++
			if (currMeeting[0] >= prevMeeting[1]) {
				prevMeeting = currMeeting;
				
				maxNumOfMeeting++;
			}
			
			// 시작 시간이 배정된 회의 종료 시간보다 작을 때
			// 종료 시간이 배정된 회의 종료 시간보다 작으면 => 회의실 배정
			else if (currMeeting[1] < prevMeeting[1]) {
				prevMeeting = currMeeting;
			}
			
		}
		
	}
	
}