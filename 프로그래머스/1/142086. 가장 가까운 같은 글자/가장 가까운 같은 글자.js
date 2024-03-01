function solution(s) {
    let queue = s.split('')
    let result = [];
    
    for (let i = 0; i < s.length; i++) {
        let alphabet = queue.shift();
        
        let sameAlphabetIndex = -1;
        for (let j = 0; j < i; j++) {
            if (alphabet === s[j]) sameAlphabetIndex = j;
        }
        
        if (sameAlphabetIndex !== -1) result.push(i - sameAlphabetIndex);
        else result.push(-1);
    }
    
    return result;
}