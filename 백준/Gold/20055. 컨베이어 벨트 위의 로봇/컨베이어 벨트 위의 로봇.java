import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 정리]
- N개의 길이를 가진 컨테이어 벨트 2줄로 구성
- 시계 방향으로 회전

- 왼쪽 위 = 올리는 위치  |  오른쪽 위 = 내리는 위치

- 가장 먼저 멜트에 올라간 로봇부터, 시계 방향으로 한 칸 이동 가능
- 단, 이동하려는 칸에 로봇이 없고, 내구도가 1 이상이어야 이동 가능
- 이동하는 칸의 내구도 1 감소

- 로봇을 올릴 때도 내구도 1 감소
- 내구도가 0이면, 로봇 올릴 수 없음

- 내구도가 0인 칸의 개수가 K 이상 -> 종료

- 작업 순서가 정해져있음에 주의
*/

/*
[풀이 방식]
- 0번 인덱스 = 올리는 위치  |  (N - 1)번 인덱스 = 내리는 위치

1. 벨트 한 칸씩 옮기기 (내구도 감소 X)
2. 옮길 수 있다면 로봇 위치 한 칸씩 이동 -> 내구도 -1
    - 이동할 칸에 로봇이 이미 있거나, 내구도가 0이면 스킵
    - 0 ~ (N - 1) 까지만 고려
3. 0번째 칸에 로봇 올리기 -> 내구도 -1

- (N - 1)번 칸에 로봇이 도착하면 내리기

- 내구도 0인 칸의 개수가 K개 이상이면 -> 종료
*/

public class Main {
    
    static BufferedReader br;
    
    static int N; // 컨베이트 벨트 한 줄의 길이 (2 <= N <= 100)
    static int K; // 내구도가 0인 칸 제한 수 (1 <= K <= 2N)
    
    static int[] DURABILITY; // 각 칸의 내구도
    static int countDurability; // 내구도가 0인 칸의 개수
    
    static boolean[] belt; // 컨베이어 벨트 (로봇이 있으면 true)
    
    static int countStep; // 단계 수
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        DURABILITY = new int[2 * N];
        
        input = br.readLine().split(" ");
        for (int i = 0; i < 2 * N; i++) {
            DURABILITY[i] = Integer.parseInt(input[i]);
        }
        
        // ------------------------- input -------------------------
        
        countStep = 0;
        
        belt = new boolean[2 * N];
        
        countDurability = 0;
        
        while (true) {
        	countStep++;
        	
        	moveBelt();
        	
        	moveRobot();
        	
        	putRobot();
        	
        	if (countDurability >= K) break;
        }
        
        System.out.println(countStep);
        
    }
    
    static void moveBelt() {
    
    	boolean temp = belt[2 * N - 1];
    	int tempDurability = DURABILITY[2 * N - 1];
    	
    	for (int i = 2 * N - 1; i > 0; i--) {
    		belt[i] = belt[i - 1];
    		DURABILITY[i] = DURABILITY[i - 1];
    	}
    	
    	belt[0] = temp;
    	DURABILITY[0] = tempDurability;
    	
    	belt[N - 1] = false;
    	
    }
    
    static void moveRobot() {
    	
    	for (int i = N - 1; i > 0; i--) {
    		if (DURABILITY[i] == 0 || belt[i] || !belt[i - 1]) continue;
    		
    		belt[i] = belt[i - 1];
    		belt[i - 1] = false;
    		
    		DURABILITY[i]--;
    		
    		if (DURABILITY[i] == 0) countDurability++;
    	}
    	
    	belt[N - 1] = false;
    	
    }
    
    static void putRobot() {
    	
    	if (DURABILITY[0] == 0 || belt[0]) return;
    	
    	belt[0] = true;
    	DURABILITY[0]--;
    	
    	if (DURABILITY[0] == 0) countDurability++;
    
    }
    
}