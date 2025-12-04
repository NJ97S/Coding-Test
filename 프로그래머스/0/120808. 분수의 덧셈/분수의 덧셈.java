class Solution {
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int[] result = new int[2];
        
        result[0] = numer1 * denom2 + numer2 * denom1;
        result[1] = denom1 * denom2;
        
        int divisor = gcd(result[0], result[1]);
        
        result[0] /= divisor;
        result[1] /= divisor;
        
        return result;
        
    }
    
    static int gcd(int a, int b) {
        
        if (b == 0) return a;
        
        return gcd(b, a % b);
        
    }
    
}