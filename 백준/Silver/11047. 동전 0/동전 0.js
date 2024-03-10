const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const temp = input.shift();
let [N, K] = temp.split(" ");

let count = 0;

for (let i = N - 1; i >= 0; i--) {
  if (+input[i] <= +K) {
    count += Math.floor(K / input[i]);
    K -= input[i] * Math.floor(K / input[i]);
  }

  if (!K) {
    console.log(count);
    break;
  }
}
