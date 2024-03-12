function solution(s, skip, index) {
    const ALPHABET = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    for (let elem of skip) {
        if (ALPHABET.indexOf(elem) !== -1) ALPHABET.splice(ALPHABET.indexOf(elem), 1)
    }
    
    let sArr = s.split('')
    
    for (let i = 0; i < sArr.length; i++) {
        if (ALPHABET.indexOf(sArr[i]) + index > ALPHABET.length - 1) {
            sArr[i] = ALPHABET[(ALPHABET.indexOf(sArr[i]) + index) % ALPHABET.length]
        } else {
            sArr[i] = ALPHABET[ALPHABET.indexOf(sArr[i]) + index]
        }
    }
    
    return sArr.join('')
}