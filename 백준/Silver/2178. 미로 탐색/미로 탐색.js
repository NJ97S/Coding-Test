const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" "));

const [[N, M], ...rest] = input;
const MAZE = rest.map((elem) => elem[0].split("").map(Number));

const bfs = (N, M, MAZE) => {
  const DIRECTION = [
    [1, 0],
    [-1, 0],
    [0, -1],
    [0, 1],
  ];

  let queue = [[0, 0]];

  let visited = Array.from({ length: N }, () => Array(M).fill(false));
  visited[0][0] = true;

  let minDistance = Array.from({ length: N }, () => Array(M).fill(0));
  minDistance[0][0] = 1;

  while (queue.length) {
    let [x, y] = queue.shift();

    for (let [dx, dy] of DIRECTION) {
      let nx = x + dx;
      let ny = y + dy;

      if (
        nx >= 0 &&
        ny >= 0 &&
        nx < N &&
        ny < M &&
        (MAZE[nx][ny] === 1) & !visited[nx][ny]
      ) {
        visited[nx][ny] = true;
        minDistance[nx][ny] = minDistance[x][y] + 1;
        queue.push([nx, ny]);
      }
    }
  }

  return minDistance[N - 1][M - 1];
};

console.log(bfs(N, M, MAZE));
