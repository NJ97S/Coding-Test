class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 1;
        
        int TOTAL = numbers.length;
        
        for (int i = 1; i < k; i++) {
            answer += 2;
            
            if (answer > TOTAL) answer -= TOTAL;
        }
        
        return answer;
    }
}