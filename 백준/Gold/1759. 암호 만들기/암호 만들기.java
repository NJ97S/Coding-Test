import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 BOJ #1759 암호 만들기
 
 - 서로 다른 L개의 알파벳 소문자로 구성
 - 최소 한 개의 모음과 최소 두 개의 자음으로 구성
 - 오름차순 정렬
 
 - C개의 문자가 주어졌을 때, 가능성 있는 암호 모두 출력
 */

public class Main {

	static BufferedReader br;
	static StringBuilder sb;
	
	static int L; // 암호 길이 (3 <= L <= C <= 15)
	static int C; // 알파벳 종류 (3 <= L <= C <= 15)
	
	static char[] alphabets;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		alphabets = new char[C];
		
		input = br.readLine().split(" ");
		
		for (int i = 0; i < input.length; i++) {
			alphabets[i] = input[i].charAt(0);
		}
		
		Arrays.sort(alphabets);
		
		dfs(0, 0, 0, 0, new char[L]);
		
		System.out.println(sb);

	}
	
	static void dfs(int depth, int start, int vowels, int consonants, char[] pick) {
		
		if (depth == L) {
			if (vowels >= 1 && consonants >= 2) sb.append(pick).append('\n');
			return;
		}
		
		for (int i = start; i < C; i++) {
			char c = alphabets[i];
			
			pick[depth] = c;
			
			if (isVowel(c)) dfs(depth + 1, i + 1, vowels + 1, consonants, pick);
			else dfs(depth + 1, i + 1, vowels, consonants + 1, pick);
		}
		
	}
	
	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}