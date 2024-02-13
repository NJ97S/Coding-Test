const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

input.shift();

for (let i = 0; i < input.length; i++) {
  for (let j = 0; j < input.length; j++) {
    if (input[j] > input[j + 1]) {
      [input[j], input[j + 1]] = [input[j + 1], input[j]];
    }
  }
}

console.log(input.join("\n"));
