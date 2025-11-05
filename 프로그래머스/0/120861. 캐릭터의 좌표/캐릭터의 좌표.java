import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1}; // up, right, down, left
    static int[] dy = {1, 0, -1, 0};
    
    static HashMap<String, Integer> map;
    
    public int[] solution(String[] keyinput, int[] board) {
        
        int X_SIZE = board[0] / 2;
        int Y_SIZE = board[1] / 2;
        
        int[] answer = new int[]{0, 0};
        
        map = new HashMap<>();
        
        map.put("up", 0);
        map.put("right", 1);
        map.put("down", 2);
        map.put("left", 3);
        
        for (String key: keyinput) {      
            int nx = answer[0] + dx[map.get(key)];
            int ny = answer[1] + dy[map.get(key)];
            
            if (nx < -X_SIZE || nx > X_SIZE || ny < -Y_SIZE || ny > Y_SIZE) continue;
            
            answer[0] = nx;
            answer[1] = ny;
        }
        
        return answer;
        
    }
    
}