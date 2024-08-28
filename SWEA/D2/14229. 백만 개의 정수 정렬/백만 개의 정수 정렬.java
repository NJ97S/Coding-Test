import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	
	static int[] INPUT;
	
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		
		INPUT = new int[1000000];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < 1000000; i++) {
			INPUT[i] = Integer.parseInt(input[i]);
		}
		
		quickSort(0, INPUT.length - 1);
		
		System.out.println(INPUT[500000]);
		
	}
	
	static void quickSort(int left, int right) {
		if (left >= right) return;
		
		int pivot = partition(left, right);
		
		quickSort(left, pivot - 1);
		quickSort(pivot + 1, right);
	}
	
	static int partition(int left, int right) {
		int value = INPUT[left];
		
		int L = left + 1;
		int R = right;
		
		while (L <= R) {
			
			while (L <= R && INPUT[L] <= value) L++;
			while (INPUT[R] > value) R--;
			
			if (L < R) {
				int temp = INPUT[L];
				INPUT[L] = INPUT[R];
				INPUT[R] = temp;
			}
			
		}
		
		INPUT[left] = INPUT[R];
		INPUT[R] = value;
		
		return R;
	}
	
}