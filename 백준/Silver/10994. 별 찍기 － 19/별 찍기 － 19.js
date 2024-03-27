const N = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

const WIDTH = 4 * N - 3;

let square = Array.from({ length: WIDTH }, () => Array(WIDTH).fill("*"));

for (let i = 1; i < WIDTH; i += 2) {
  let start = i;
  let end = i + (WIDTH - 2 * i) - 1;

  for (let x = start; x <= end; x++) {
    square[start][x] = " ";
    square[x][start] = " ";

    square[end][x] = " ";
    square[x][end] = " ";
  }
}

square.forEach((row) => console.log(row.join("")));
