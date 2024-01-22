const input = +require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim();

let answer = (1 + (2 ** input)) ** 2;
console.log(answer);