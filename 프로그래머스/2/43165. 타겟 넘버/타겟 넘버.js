function solution(numbers, target) {
    let count = 0;

    let parentNodes = [0];  // 시작 정점을 0으로 잡음.

    for (let number of numbers) {
        let temp = [];  // 중간 합 임시로 저장할 배열
        for (let node of parentNodes) {
            temp.push(node + number, node - number);
        }
        parentNodes = temp;
    }

    for (let node of parentNodes) {
        if (node === target) count++;
    }
    
    return count;
}
