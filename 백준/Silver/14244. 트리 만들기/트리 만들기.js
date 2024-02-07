const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0].split(" ")[0];
const m = +input[0].split(" ")[1];

// m까지 1번 노드에 연결
// n-1이 m보다 크면, 남은 노드 m번 노드에 연결

for (let node = 0; node < m; node++) {
  if (node === 0) console.log(0, 1);
  else console.log(1, node + 1);
}

if (n - 1 > m) {
  for (let node = m; node < n - 1; node++) {
    console.log(node, node + 1);
  }
}
