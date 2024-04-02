function solution(N, stages) {
    let failureRate = {};
    stages.sort((a, b) => a - b);
    stages.forEach((elem) => {
        let allClearPlayer = 0;
        if (elem > N) allClearPlayer++;
        
        if (elem in failureRate || elem > N) return;
        
        let totalPlayer = stages.length - stages.indexOf(elem) + allClearPlayer;
        let noClearPlayer = stages.lastIndexOf(elem) - stages.indexOf(elem) + 1;
        failureRate[elem] = noClearPlayer / totalPlayer;
    })
    for (let i = 1; i <= N; i++) {
        if (!(i in failureRate)) failureRate[i] = 0;
    }
    
    failureRate = Object.entries(failureRate).sort((a, b) => b[1] - a[1]);
    
    let answer = [];
    for (let elem of failureRate) {
        answer.push(+elem[0]);
    }
    return answer;
}