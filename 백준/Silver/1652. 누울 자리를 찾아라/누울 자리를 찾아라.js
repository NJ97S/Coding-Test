const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" "));

const N = +input.shift();

function countSpaces(mode) {
  let count = 0;
  for (let i = 0; i < N; i++) {
    let spaceCount = 0;
    for (let j = 0; j < N; j++) {
      const cell = mode === "row" ? input[i][0][j] : input[j][0][i];

      if (cell === ".") {
        spaceCount++;
        if (j === N - 1 && spaceCount >= 2) count++;
      } else {
        if (spaceCount >= 2) count++;
        spaceCount = 0;
      }
    }
  }
  return count;
}

const rowCount = countSpaces("row");
const colCount = countSpaces("col");

console.log(`${rowCount} ${colCount}`);
