class Solution {
    public String solution(String s) {
        
        String[] numbers = s.split(" ");
        
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);
        
        for (String str: numbers) {
            int num = Integer.parseInt(str);
            
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        return min + " " + max;
    }
}