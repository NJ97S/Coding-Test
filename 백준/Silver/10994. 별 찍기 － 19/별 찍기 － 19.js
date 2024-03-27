const N = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

const WIDTH = 4 * N - 3;

let square = Array.from({ length: WIDTH }, () => Array(WIDTH).fill("*"));

for (let i = 1; i < WIDTH; i += 2) {
  let innerWidth = WIDTH - 2 * i;
  let start = i;
  let end = i + innerWidth - 1;

  for (let x = start; x <= end; x++) {
    square[start][x] = " ";
    square[end][x] = " ";
  }

  for (let y = start; y <= end; y++) {
    square[y][start] = " ";
    square[y][end] = " ";
  }
}

square.forEach((row) => console.log(row.join("")));
