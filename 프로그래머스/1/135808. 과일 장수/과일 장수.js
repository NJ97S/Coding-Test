function solution(k, m, score) {    
    score.sort((a, b) => a - b);
    
    let totalPrice = 0;
    
    while (score.length >= m) {
        let appleBox = score.splice(-m, m);
        totalPrice += appleBox[0] * m;
    }
    
    return totalPrice;
}