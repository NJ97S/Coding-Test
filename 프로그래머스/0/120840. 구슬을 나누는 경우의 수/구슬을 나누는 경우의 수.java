class Solution {
    public int solution(int balls, int share) {
        
        if (balls == share) return 1;
        
        long answer = 1;
        
        int tempBalls = balls;
        
        for (int i = 1; i <= balls - share; i++) {
            answer = answer * (tempBalls--) / i;
        }
        
        return (int)answer;
        
    }
}