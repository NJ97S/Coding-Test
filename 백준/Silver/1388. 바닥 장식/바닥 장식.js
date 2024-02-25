const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [first, ...floor] = input;
const [N, M] = first.split(" ");

// 0과 1로 이루어진 행렬로 표현
let Array = [];
for (let i = 0; i < floor.length; i++) {
  Array[i] = [];
  let tempArray = floor[i].split("");
  if (tempArray[tempArray.length - 1] === "\r") tempArray.pop();

  for (let elem of tempArray) {
    if (elem === "-") Array[i].push(0);
    else Array[i].push(1);
  }
}

// 왼쪽 요소와 같지 않은 0이거나, 위쪽 요소와 같지 않은 1일 경우, count++
let count = 0;
function countBoard(Array) {
  for (let j = 0; j < M; j++) {
    if (Array[0][j] === 0 && Array[0][j] === Array[0][j - 1]) continue;
    else count++;
  }

  for (let i = 1; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (Array[i][j] === 0 && Array[i][j] === Array[i][j - 1]) continue;
      else if (Array[i][j] === 1 && Array[i][j] === Array[i - 1][j]) continue;
      else count++;
    }
  }
  console.log(count);
}

countBoard(Array);
