const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

function solveZ(N, r, c) {
    let size = Math.pow(2, N);
    let result = 0;

    while (size > 1) {
        size /= 2;

        if (r < size && c < size) { 
        } else if (r < size && c >= size) {
            result += size * size;
            c -= size;
        } else if (r >= size && c < size) {
            result += 2 * size * size;
            r -= size;
        } else {
            result += 3 * size * size;
            r -= size;
            c -= size;
        }
    }

    return result;
}

function main() {
    const [[N, r, c]] = input;
    const result = solveZ(N, r, c);
    console.log(result);
}

main();
