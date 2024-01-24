const input = +require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim();

let count = 0;

for (let i = 1; i <= input - 1; i++) {
  count += input - i;
}

console.log(count);
console.log(2);