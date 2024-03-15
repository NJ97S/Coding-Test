const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [tempN, haveCards, tempM, getCards] = input;

const N = +tempN.join("");
haveCards.sort((a, b) => a - b);

let answer = [];

for (let card of getCards) {
  let upperBound = upperBoundSearch(haveCards, card, 0, N);
  let lowerBound = lowerBoundSearch(haveCards, card, 0, N);

  answer.push(upperBound - lowerBound);
}

console.log(...answer);

function lowerBoundSearch(list, target, left, right) {
  let mid = 0;

  while (left < right) {
    mid = Math.floor((left + right) / 2);

    if (list[mid] >= target) right = mid;
    else {
      left = mid + 1;
    }
  }

  return right;
}

function upperBoundSearch(list, target, left, right) {
  let mid = 0;

  while (left < right) {
    mid = Math.floor((left + right) / 2);

    if (list[mid] > target) {
      right = mid;
    } else left = mid + 1;
  }

  return right;
}
