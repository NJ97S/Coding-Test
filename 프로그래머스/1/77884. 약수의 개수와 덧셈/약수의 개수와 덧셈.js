function solution(left, right) {
    let answer = 0;
    
    function divisorNum (number) {
        let count = 0;
        for (let i = 1; i <= number; i++) {
            if (number % i === 0) count++;
        }
        return count;
    }
    
    for (let i = left; i <= right; i++) {
        if (divisorNum(i) % 2) answer -= i
        else answer += i
    }
    
    return answer;
}