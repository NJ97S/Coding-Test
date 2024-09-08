import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 사람 수
	static int K; // 양의 정수
	
	static List<Integer> person;
	
	static int[] order; // 요세푸스 순열
	static int countOfPerson;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		person = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			person.add(i);
		}
		
		// ------------------------ input ------------------------
		
		order = new int[N - 1];
		
		removePerson(0);
		
		sb.append("<");
		
		for (int elem: order) {
			sb.append(elem).append(", ");
		}
		
		sb.append(person.get(0)).append(">");
		
		System.out.println(sb);
		
	}
	
	static void removePerson(int idx) {
		
		if (person.size() <= 1) return;
		
		int tIdx = (idx + K - 1) % (N - countOfPerson);
		order[countOfPerson] = person.get(tIdx);
		countOfPerson++;

		person.remove(tIdx);
		
		removePerson(tIdx);
		
	}
	
}