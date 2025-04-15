import java.util.*;

class Solution {
    
    static int N;
    static int M;
    
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};
    
    static boolean[][] visited;
    
    static int answer;
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        
        answer = 0;
        
        bfs(maps);
        
        return answer > 0 ? answer : -1;
        
    }
    
    static void bfs(int[][] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0, 1}); // 시작 좌표, 지나간 칸
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || maps[nr][nc] == 0) continue;
                
                if (nr == N - 1 && nc == M - 1) answer = curr[2] + 1;
                
                queue.add(new int[] {nr, nc, curr[2] + 1});
                visited[nr][nc] = true;
            }
        }
        
    }
    
}