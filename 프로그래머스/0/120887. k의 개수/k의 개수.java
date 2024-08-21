class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int num = i; num <= j; num++) {
            answer += getCount(num, k);
        }
        
        return answer;
    }
    
    static int getCount(int num, int target) {
        int count = 0;
        
        while (num > 0) {
            if (num % 10 == target) count++;
            
            num /= 10;
        }
        
        return count;
    }
}