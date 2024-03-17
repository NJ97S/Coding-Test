const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [[N, M], [...TREES]] = input;

let answerCandidates = [];
binarySearch(TREES, M, 0, Math.max(...TREES));
console.log(Math.max(...answerCandidates));

function binarySearch(TREES, target, left, right) {
  let mid = 0;

  while (left <= right) {
    mid = Math.floor((left + right) / 2);

    let heightOfTrees = TREES.reduce((acc, elem) => {
      if (elem - mid > 0) return acc + (elem - mid);
      else return acc;
    }, 0);

    if (heightOfTrees === target) {
      answerCandidates.push(mid);
      return;
    } else if (heightOfTrees > target) {
      answerCandidates.push(mid);
      left = mid + 1;
    } else right = mid - 1;
  }
}
