const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const info = input.shift();
const [N, M, V] = info;

// 인접 리스트 구현
let list = {};
for (let i = 1; i <= N; i++) {
  list[i] = [];
}

for (let node of input) {
  if (!list[node[0]].includes([node[1]])) {
    list[node[0]].push(node[1]);
  }
  if (!list[node[1]].includes([node[0]])) {
    list[node[1]].push(node[0]);
  }
}

// DFS
dfs(list, V);

function dfs(list, V) {
  for (let index in list) {
    list[index].sort((a, b) => b - a);
  }

  let stack = [V];
  let visited = [];

  while (stack.length !== 0) {
    let currentNode = stack.pop();

    if (!visited.includes(currentNode)) {
      visited.push(currentNode);

      for (let node of list[currentNode]) {
        if (!visited.includes(node)) {
          stack.push(node);
        }
      }
    }
  }

  console.log(visited.join(" "));
}

// BFS
bfs(list, V);

function bfs(list, V) {
  for (let index in list) {
    list[index].sort((a, b) => a - b);
  }

  let queue = [V];
  let visited = [];

  while (queue.length !== 0) {
    let currentNode = queue.shift();

    if (!visited.includes(currentNode)) {
      visited.push(currentNode);

      for (let node of list[currentNode]) {
        if (!visited.includes(node) && !queue.includes(node)) queue.push(node);
      }
    }
  }

  console.log(visited.join(" "));
}
