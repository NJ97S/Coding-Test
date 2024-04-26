// 1. yellow 약수 큰 수부터 구하기 => yellow 가로 길이 => yellow 세로 길이는 몫으로 구하기
// 2. 2 * (가로길이 + 세로길이) + 4가 brown이면 => 각 길이의 +2 값을 반환

function solution(brown, yellow) {
    let yellowDivisor = [];
    for (let i = yellow; i > 0; i--) {
        if (yellow % i === 0) yellowDivisor.push(i);
    }
    
    for (let elem of yellowDivisor) {
        let yellowWidth = elem;
        let yellowHeight = yellow / elem;
        
        if (brown === 2 * (yellowWidth + yellowHeight) + 4) return ([yellowWidth+2, yellowHeight+2]);
    }
}