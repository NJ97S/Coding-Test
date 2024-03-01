function solution(s) {
    let answer = false;
    
    const WORD = s.split('')
    const NUMBERS = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    
    if (s.length === 4 || s.length === 6) answer = true;
    
    for (let elem of WORD) {
        if (!NUMBERS.includes(+elem)) answer = false;
    }
        
    return answer;
}