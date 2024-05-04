const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [N, TREE_LENGTH, GROWING_LENGTH] = input;

let trees = Array(TREE_LENGTH);
for (let i = 0; i < N[0]; i++) {
  trees[i] = [GROWING_LENGTH[i], TREE_LENGTH[i]];
}
trees.sort((a, b) => a[0] - b[0]);

let sumOfTreeLength = 0;

for (let day = 0; day < N[0]; day++) {
  sumOfTreeLength += trees[day][1] + trees[day][0] * day;
}

console.log(sumOfTreeLength);
