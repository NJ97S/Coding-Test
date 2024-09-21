import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
[문제 링크]
- https://www.acmicpc.net/problem/18870
*/

/*
[문제 정리]
- 2 초 / 512 MB

- 수직선 위에 N개의 좌표 존재
- 각 좌표에 대해, 해당 좌표 값보다 작은 값을 가진 좌표의 개수 구하기
*/

/*
[풀이 방식]
- 좌표 배열 복사본을 만들어서 정렬
  - treeSet으로 중복 제거 및 정렬 후, 배열로 변환
- 원본 좌표 배열을 돌면서, 복사본을 이용하여 이분 탐색으로 작은 값 개수 찾기
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	static int[] NUMBERS;
	
	static Integer[] copy; // NUMBERS 배열 복사본
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		NUMBERS = new int[N];
		Set<Integer> set = new TreeSet<>();
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input[i]);
			
			NUMBERS[i] = num;
			set.add(num);
		}
		
		// ---------------------- input ----------------------
		
		copy = set.toArray(new Integer[0]);
		
		for (int number: NUMBERS) {
			sb.append(binarySearch(number) + 1).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	static int binarySearch(int target) {
		
		int result = -1;
		
		int left = 0;
		int right = copy.length - 1;
		
		while (left <= right) {
			
			int mid = (left + right) / 2;
			
			if (copy[mid] < target) {
				left = mid + 1;
				
				result = Math.max(result, mid);
			} else {
				right = mid - 1;
			}
			
		}
		
		return result;
		
	}
	
}