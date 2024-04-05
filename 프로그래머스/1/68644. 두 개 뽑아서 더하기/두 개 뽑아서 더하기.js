function solution(numbers) {
    let answer = [];
    
    for (let idx1 = 0; idx1 < numbers.length; idx1++) {
        for (let idx2 = 0; idx2 < numbers.length; idx2++) {
            if (idx1 === idx2) continue;
            
            let sum = numbers[idx1] + numbers[idx2];
            if (!answer.includes(sum)) answer.push(sum);
        }
    }
    
    return answer.sort((a, b) => a - b);
}