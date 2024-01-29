const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n").map(el=>el.split(" "));
const [N, ...informations] = input;

informations.sort((a, b) => a[0] - b[0]);

for (elem of informations) {
  console.log(`${elem[0]} ${elem[1]}`);
}