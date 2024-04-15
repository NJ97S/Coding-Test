function getFactorial(num) {
    let value = BigInt(1);
    while (num >= BigInt(1)) {
        value *= num;
        num--;
    }
    return value;
}

function solution(n) {
    let answer = BigInt(1);
    
    if (n < 2) return Number(answer);
    
    let arrayN = new Array(n).fill(BigInt(1));
    let countTwo = BigInt(0);
    while (arrayN.length >= 2) {
        arrayN.splice(-2, 2);
        countTwo++;
        answer += getFactorial(BigInt(arrayN.length) + countTwo) / (getFactorial(BigInt(arrayN.length)) * getFactorial(countTwo));
    }
    
    return Number(answer % BigInt(1234567));
}
