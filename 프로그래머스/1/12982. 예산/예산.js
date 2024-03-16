function solution(d, budget) {
    d.sort((a, b) => a - b);
    
    let count = 0;
    d.reduce((acc, el) => {
        if (acc + el > budget) return acc;
        else {
            count ++;
            return acc + el;
        }
    }, 0)
    
    return count;
}