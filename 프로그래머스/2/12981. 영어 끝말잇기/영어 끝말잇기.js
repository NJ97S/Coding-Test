function solution(n, words) {
    let answer = [0, 0];
    
    let count = 1;
    
    for (let i = 1; i < words.length; i++) {
        let wordArr = words[i].split('');
        let lastWordArr = words[i - 1].split('');
        
        if (i % n === 0) count++;
        
        if (wordArr.shift() !== lastWordArr.pop() || words.indexOf(words[i]) < i) {  
            answer.splice(0, 2, i % n + 1, count)
            return answer;
        }
    }
    
    return answer;
}