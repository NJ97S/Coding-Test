const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const [X, Y] = input;
const Z = getAverage(X, Y);

console.log(binarySearch(Z, 1, X));

function getAverage(totalNum, winNum) {
  let average = Math.floor((winNum * 100 / totalNum));

  if (average <= 100) return average;
  else return 100;
}

function binarySearch(target, left, right) {
  let mid = 0;
  let answer = -1;

  while (left <= right) {
    mid = Math.floor((left + right) / 2);

    let newWinRatio = getAverage(X + mid, Y + mid);

    if (newWinRatio > target) {
      answer = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return answer;
}
