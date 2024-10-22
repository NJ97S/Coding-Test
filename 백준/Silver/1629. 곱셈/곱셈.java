import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static int A; // (1 <= A, B, C < 2^31)
	static int B;
	static int C;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);
		
		// -------------------- input --------------------
		
		System.out.println(pow(B));
		
	}
	
	// exp: 지수
	static long pow(int exp) {
		
		if (exp == 0) return 1;
		
		long temp = pow(exp / 2);
		
		if (exp % 2 == 0) return temp * temp % C;
		else return (temp * temp % C) * A % C;
		
	}
	
}