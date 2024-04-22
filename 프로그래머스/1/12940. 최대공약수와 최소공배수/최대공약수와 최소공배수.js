function getGCD (num1, num2) {
    let biggerNum = Math.max(num1, num2);
    let smallerNum = Math.min(num1, num2);

    if (!(biggerNum % smallerNum)) return smallerNum;

    if (biggerNum % smallerNum) {
        biggerNum = biggerNum % smallerNum;
        return getGCD(biggerNum, smallerNum);
    }
}

function solution(n, m) {
    let answer = [];
    
    answer.push(getGCD(n, m));
    answer.push(n * m / getGCD(n, m));
    
    return answer;
}