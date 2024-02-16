function solution(survey, choices) {
    let answer = '';
    
    const MBTI = ['RT', 'CF', 'JM', 'AN']
    let points = [0, 0, 0, 0]
    
    for (let i = 0; i < survey.length; i++) {
        if (MBTI.includes(survey[i])) {
            let idx = MBTI.indexOf(survey[i]);
            if (choices[i] < 4) {
                points[idx] -= 4 - choices[i]
            } else if (choices[i] > 4) {
                points[idx] += choices[i] - 4
            }
        } else {
            let reverseSurvey = survey[i].split('').reverse().join('')
            let idx = MBTI.indexOf(reverseSurvey);
            if (choices[i] < 4) {
                points[idx] += 4 - choices[i]
            } else if (choices[i] > 4) {
                points[idx] -= choices[i] - 4
            }
        }
    }
    
    for (let i = 0; i < 4; i++) {
        let type = MBTI[i].split('')
        if (points[i] < 0) {
            answer += type[0]
        } else if (points[i] > 0) {
            answer += type[1]
        } else {
            type.sort()
            answer += type[0]
        }
    }
    
    return answer;
}