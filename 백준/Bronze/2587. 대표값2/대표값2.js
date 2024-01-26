const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n").map(Number);

input.sort((a, b) => a - b);

let sum = 0;

for (let num of input) {
  sum += num;
}

let mean = sum / input.length;

let median = 0;

if (input.length % 2) {
  median = input[(input.length - 1) / 2];
} else {
  median = input[input.length / 2 - 1];
}

console.log(mean);
console.log(median);