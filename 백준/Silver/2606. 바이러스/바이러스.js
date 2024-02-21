const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [, , ...edges] = input;

function bfs(edges, start) {
  let queue = [];
  let visited = [];

  queue.push(start);

  while (queue.length !== 0) {
    let currentNode = queue.shift();

    if (!visited.includes(currentNode)) {
      visited.push(currentNode);
      for (let edge of edges) {
        if (edge[0] === currentNode) queue.push(edge[1]);
        else if (edge[1] === currentNode) queue.push(edge[0]);
      }
    }
  }

  console.log(visited.length - 1); // 1번 컴퓨터는 카운트에서 제외
}

bfs(edges, 1);
