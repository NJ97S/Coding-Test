import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    
    static int[][] tree;
    static String[] value;
    static StringBuilder sb;
    static Stack<Integer> stack;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.valueOf(br.readLine());
            
            tree = new int[N + 1][2];
            value = new String[N + 1];
            
            stack = new Stack<>();
            
            for (int i = 1; i <= N; i++) {
                String[] line = br.readLine().split(" ");
                
                value[i] = line[1];
                
                if (line.length == 4) {
                    int a = Integer.valueOf(line[0]);
                    int b = Integer.valueOf(line[2]);
                    int c = Integer.valueOf(line[3]);
                    
                    tree[a][0] = b;
                    tree[a][1] = c;
                }
            }
            
            postOrder(1);
            
            int answer = stack.pop();
            
            System.out.printf("#%d %d\n", testCase, answer);
        }
        
    }
    
    static void postOrder(int root) {
        // 자식 노드가 없을 때
        if (tree[root][0] == 0 && tree[root][1] == 0) {
            operation(value[root]);
            return;
        }
        // 자식 노드가 있을 때
    	if (tree[root][0] != 0) postOrder(tree[root][0]);
    	if (tree[root][1] != 0) postOrder(tree[root][1]);
        
        operation(value[root]);
    }
    
    static void operation(String elem) {
    	// 숫자일 경우
    	if (!elem.equals("+") && !elem.equals("-") && !elem.equals("*") && !elem.equals("/")) {
    		stack.push(Integer.valueOf(elem));
    		return;
    	}
    	
    	// 연산자일 경우
    	int num2 = stack.pop();
    	int num1 = stack.pop();
    	
    	switch(elem) {
    	case "+":
    		stack.push(num1 + num2);
    		break;
    	case "-":
    		stack.push(num1 - num2);
    		break;
    	case "*":
    		stack.push(num1 * num2);
    		break;
    	case "/":
    		stack.push(num1 / num2);
    		break;
    	}
    }
    
}