import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static char INPUT;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		INPUT = br.readLine().charAt(0);
		
		System.out.println((int) INPUT);
		
	}
	
}