function solution(n) {
    let first = BigInt(0);
    let second = BigInt(1);
    
    for (let i = 2; i <= n; i++) {
        let temp = second;
        second = first + second;
        first = temp;
    }
    
    return second % BigInt(1234567);
}