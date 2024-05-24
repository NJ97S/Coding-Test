const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [N] = input.shift();

input.sort((a, b) => {
  if (a[1] === b[1]) return a[0] - b[0];
  return a[1] - b[1];
});

let count = 0;
let endTime = 0;

for (let i = 0; i < N; i++) {
  const [START, END] = input[i];

  if (START >= endTime) {
    endTime = END;
    count++;
  }
}

console.log(count);
