const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" "));

const [HEIGHT, WIDTH] = input.shift();

const TREASURE_MAP = input.map((line) =>
  line[0].trim().replace(/\r/g, "").split("")
);

const DIRECTION = [
  [1, 0],
  [-1, 0],
  [0, -1],
  [0, 1],
];

const getMinTime = (treasureMap) => {
  let maxDistance = 0;

  for (let j = 0; j < HEIGHT; j++) {
    for (let i = 0; i < WIDTH; i++) {
      if (treasureMap[j][i] === "L") {
        let queue = [[i, j]];

        let visited = Array.from({ length: +HEIGHT }, () =>
          Array(+WIDTH).fill(false)
        );
        visited[j][i] = true;

        let minDistance = Array.from({ length: +HEIGHT }, () =>
          Array(+WIDTH).fill(Number.MAX_SAFE_INTEGER)
        );
        minDistance[j][i] = 0;

        while (queue.length) {
          let [x, y] = queue.shift();

          for (let [dx, dy] of DIRECTION) {
            let nx = x + dx;
            let ny = y + dy;

            if (
              nx >= 0 &&
              ny >= 0 &&
              nx < +WIDTH &&
              ny < +HEIGHT &&
              treasureMap[ny][nx] === "L" &&
              !visited[ny][nx]
            ) {
              visited[ny][nx] = true;
              minDistance[ny][nx] = minDistance[y][x] + 1;
              queue.push([nx, ny]);

              maxDistance = Math.max(maxDistance, minDistance[ny][nx]);
            }
          }
        }
      }
    }
  }

  return maxDistance;
};

console.log(getMinTime(TREASURE_MAP));
