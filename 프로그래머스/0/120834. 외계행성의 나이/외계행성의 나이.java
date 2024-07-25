class Solution {
    public String solution(int age) {
        String answer = "";
        
        int cnt = 0;
        int tempAge = age;
        while (tempAge > 0) {
            tempAge /= 10;
            cnt++;
        }
        
        int[] ageArr = new int[cnt];
        for (int i = cnt - 1; i >= 0; i--) {
            ageArr[i] = age % 10;
            age /= 10;
        }
        
        for (int elem: ageArr) {
            answer += (char)(elem + 97);
        }
        
        return answer;
    }
}