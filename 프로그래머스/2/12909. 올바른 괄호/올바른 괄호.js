function solution(s){
    let answer = true;
    
    const input = s.split('');
    
    if (input[0] === `)` || input[s.length - 1] === `(`) {
        answer = false;
        
    } else {
        let leftCount = 0;
        let rightCount = 0;
        
        for (let elem of input) {
            if (elem === `(`) leftCount++;
            else rightCount++;
            
            if (leftCount < rightCount) {
                answer = false;
                break;
            }
        }
        
        if (leftCount !== rightCount) answer = false;
    }
    
    return answer;
}