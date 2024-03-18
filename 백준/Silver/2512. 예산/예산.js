const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [[N], REQUEST, [BUDGET]] = input;

if (sumRequestBudget(REQUEST) <= BUDGET) console.log(Math.max(...REQUEST));
else console.log(binarySearch(REQUEST, BUDGET, 0, Math.max(...REQUEST)));

function sumRequestBudget(request) {
  const sum = request.reduce((acc, elem) => {
    return acc + elem;
  }, 0);

  return sum;
}

function binarySearch(list, target, left, right) {
  let answerCandidates = [];

  let mid = 0;

  while (left <= right) {
    mid = Math.floor((left + right) / 2);

    let newBudget = [];
    for (let elem of REQUEST) {
      if (elem <= mid) newBudget.push(elem);
      else newBudget.push(mid);
    }

    if (sumRequestBudget(newBudget) === target) {
      return mid;
    } else if (sumRequestBudget(newBudget) < target) {
      answerCandidates.push(mid);
      left = mid + 1;
    } else right = mid - 1;
  }

  return Math.max(...answerCandidates);
}
