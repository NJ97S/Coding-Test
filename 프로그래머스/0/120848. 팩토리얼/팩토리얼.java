class Solution {
    public int solution(int n) {
        int result = 1;
        int number = 0;
        
        while (true) {
            if (result * (number + 1) > n) break;
            
            result *= ++number;
        }
        
        return number;
    }
}