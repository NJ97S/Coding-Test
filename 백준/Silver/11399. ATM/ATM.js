const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

input.shift();
const times = input[0];

times.sort((a, b) => a - b);

let totalTime = 0;

times.reduce((acc, el) => {
  totalTime += acc + el;
  return acc + el;
}, 0);

console.log(totalTime);
