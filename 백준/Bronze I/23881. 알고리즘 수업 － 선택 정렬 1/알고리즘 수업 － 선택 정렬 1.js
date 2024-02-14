const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [N, K] = input[0];
const numbers = input[1];

selectionSort();

// 선택 정렬 함수
function selectionSort() {
  let count = 0;

  for (let curIdx = N - 1; curIdx > 0; curIdx--) {
    let maxIndex = curIdx;

    for (let compIdx = 0; compIdx < curIdx; compIdx++) {
      if (numbers[compIdx] > numbers[maxIndex]) {
        maxIndex = compIdx;
      }
    }

    if (curIdx !== maxIndex) {
      [numbers[curIdx], numbers[maxIndex]] = [
        numbers[maxIndex],
        numbers[curIdx],
      ];
      count++;
    }

    if (count === K) {
      console.log(`${numbers[maxIndex]} ${numbers[curIdx]}`);
      return;
    }
  }

  console.log(-1);
}
