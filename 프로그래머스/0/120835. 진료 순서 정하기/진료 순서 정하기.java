class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
            
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = 1;
            
            for (int j = 0; j < emergency.length; j++) {
                if (i == j) continue;
                
                if (emergency[j] > emergency[i]) answer[i]++;
            }
        }
        
        return answer;
    }
}