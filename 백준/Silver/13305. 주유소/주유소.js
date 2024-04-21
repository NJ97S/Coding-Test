const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [N, roads, cities] = input;

let totalCost = 0;
let minPrice = cities[0];

for (let i = 0; i < N - 1; i++) {
  totalCost += minPrice * roads[i];
  
  if (cities[i + 1] < minPrice) {
    minPrice = cities[i + 1];
  }
}

console.log(totalCost);
