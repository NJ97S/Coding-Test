function solution(progresses, speeds) {
    let answer = [];
   
    while (progresses.length > 0) {
        let count = 0;
        for (let i = 0; i < progresses.length; i++) {
            if (progresses[i] < 100) {
                progresses[i] += speeds[i];
            }
        }
        while (progresses[0] >= 100) {
            progresses.shift();
            speeds.shift();
            count++;
        }
        if (count > 0) {
            answer.push(count);
        }
    }       
    
    return answer;
}