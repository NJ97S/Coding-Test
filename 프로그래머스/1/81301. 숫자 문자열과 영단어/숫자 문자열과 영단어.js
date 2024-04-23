// s를 배열로 변환 (split)
// 앞에서 부터 하나씩 꺼내봄
// 1. 숫자일 경우, answer에 추가
// 2. 문자일 경우, 배열에 넣고, 문자열이 NUMBER에 존재하는 지 여부 확인 -> 존재하면 배열 초기화 후 answer에 숫자로 추가

const STRING = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
const NUMBER = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

function solution(s) {
    let answer = [];
    
    let sArr = s.split('');
    
    let tempArr = [];
    while (sArr.length > 0) {
        let elem = sArr.shift();
        
        if (NUMBER.includes(+elem)) answer.push(+elem);
        else {
            tempArr.push(elem);
            let tempString = tempArr.join('');
            if (STRING.includes(tempString)) {
                answer.push(STRING.indexOf(tempString));
                tempArr = [];
            }
        }
    }
    
    return +answer.join('');
}