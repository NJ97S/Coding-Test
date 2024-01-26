const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n").map(Number);

input.sort((a, b) => a - b);  // 오름차순 정렬

let mean = input.reduce((acc, el) => acc + el, 0) / input.length;
let median = input[(input.length - 1) / 2];

console.log(mean);
console.log(median);