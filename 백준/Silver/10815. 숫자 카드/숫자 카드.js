const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n").map(el=>el.split(" ").map(Number));

const cardNumber = new Set(input[1]);

let answer = [];

for (card of input[3]) {
  if (cardNumber.has(card)) {
    answer.push(1);
  } else {
    answer.push(0);
  }
}

console.log(answer.join(' '));