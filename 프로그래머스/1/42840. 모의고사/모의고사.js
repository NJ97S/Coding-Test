function solution(answers) {
    const GG = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
        
    let points = [0, 0, 0]
    
    for (let i = 0; i < answers.length; i++) {
        for (let j = 0; j < 3; j++) {
            if (answers[i] === GG[j][i % GG[j].length]) points[j] ++
        }
    }
    
    let answer = [];
    for (let i = 0; i < points.length; i++) {
        if (points[i] === Math.max(points[0], points[1], points[2])) answer.push(i + 1)
    }
    
    return answer
}