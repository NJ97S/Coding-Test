const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [, SOLUTIONS] = input;

SOLUTIONS.sort((a, b) => a - b);

const findSolutionClosestToZero = (solutions) => {
  let left = 0;
  let right = solutions.length - 1;

  let minSum = Number.MAX_SAFE_INTEGER;
  let pair = [];

  while (left < right) {
    let sum = solutions[left] + solutions[right];

    if (Math.abs(sum) < minSum) {
      minSum = Math.abs(sum);
      pair = [solutions[left], solutions[right]];
    }

    if (!sum) return pair;
    else if (sum < 0) left++;
    else if (sum > 0) right--;
  }

  return pair;
};

console.log(...findSolutionClosestToZero(SOLUTIONS));
