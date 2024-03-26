const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [[N], ...PEOPLE] = input;

let grade = [];

for (let i = 0; i < N; i++) {
  const PERSON = PEOPLE.slice(i, i + 1).flat();
  let count = 0;

  for (let person of PEOPLE) {
    if (PERSON[0] < person[0] && PERSON[1] < person[1]) count++;
  }

  grade.push(count + 1);
}

console.log(...grade);
