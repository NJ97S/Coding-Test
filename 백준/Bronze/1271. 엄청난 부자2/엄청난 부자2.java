import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static BigInteger N; // 나눠주어야 하는 총 금액
	static BigInteger M; // 돈을 나눠가질 사람 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		N = new BigInteger(input[0]);
		M = new BigInteger(input[1]);
		
		System.out.println(N.divide(M) + " " + N.remainder(M));
		
	}
	
}