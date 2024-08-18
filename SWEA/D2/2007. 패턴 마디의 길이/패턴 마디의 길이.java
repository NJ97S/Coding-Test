import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
30초 / 문자열 길이 30 / 마디 최대 길이 10

1. 문자열 전체 길이의 약수 찾기 (10 이하)
2. 약수만큼의 길이를 가진 단어 만들기
3. 해당 단어가 반복되는 지 확인
*/

public class Solution {
	
	static BufferedReader br;
	
	static String INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		final int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			INPUT = br.readLine();
			
			for (int size = 1; size <= 10; size++) {
				String word = getWord(size);
				
				if (isRepeat(word)) {
					System.out.printf("#%d %d\n", testCase, word.length());
					break;
				}
			}
		}
		
	}
	
	static String getWord(int size) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < size; i++) {
			sb.append(INPUT.charAt(i));
		}
		
		return sb.toString();
	}
	
	static boolean isRepeat(String word) {
		for (int i = word.length(); i < word.length() * 2; i++) {
			if (INPUT.charAt(i) != word.charAt(i - word.length())) return false;
		}
		
		return true;
	}

}