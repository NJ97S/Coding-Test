import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int TYPE;
	static String INPUT;
	
	static List<String> words;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		TYPE = Integer.parseInt(input[0]);
		INPUT = input[1];
		
		// --------------------- input ---------------------
		
		words = new ArrayList<>();
		
		// 각 단어를 분리해서 list에 저장
		if (TYPE == 1 || TYPE == 3) {
			String temp = "";
			
			for (int i = 0; i < INPUT.length(); i++) {				
				temp += INPUT.charAt(i);
				
				if (i < INPUT.length() - 1 && INPUT.charAt(i + 1) >= 'A' && INPUT.charAt(i + 1) <= 'Z') {
					words.add(temp.toLowerCase());
					temp = "";
				}
				
				if (i == INPUT.length() - 1) words.add(temp.toLowerCase());
			}
		}
		
		else if (TYPE == 2) {
			String[] temp = INPUT.split("_");
			
			for (int i = 0; i < temp.length; i++) {
				words.add(temp[i]);
			}
		}
		
		// 카멜 표기법
		sb.append(words.get(0));
		
		for (int i = 1; i < words.size(); i++) {
			char first = (char) ((int) words.get(i).charAt(0) - 32);
			
			sb.append(first);
			
			for (int j = 1; j < words.get(i).length(); j++) {
				sb.append(words.get(i).charAt(j));
			}
		}
		
		sb.append("\n");
		
		// 스네이크 표기법
		sb.append(words.get(0));
		
		for (int i = 1; i < words.size(); i++) {
			sb.append("_").append(words.get(i));
		}
		
		sb.append("\n");
		
		// 파스칼 표기법
		for (int i = 0; i < words.size(); i++) {
			char first = (char) ((int) words.get(i).charAt(0) - 32);
			
			sb.append(first);
			
			for (int j = 1; j < words.get(i).length(); j++) {
				sb.append(words.get(i).charAt(j));
			}
		}
		
		sb.append("\n");
		
		// 정답 출력
		System.out.println(sb);
		
	}
	
}