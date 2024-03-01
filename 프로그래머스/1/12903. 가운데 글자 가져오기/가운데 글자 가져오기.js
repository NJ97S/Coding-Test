function solution(s) {
    let word = s.split('');
    
    while (word.length > 2) {
        word.shift();
        word.pop();
    }
    
    return word.join('')
}