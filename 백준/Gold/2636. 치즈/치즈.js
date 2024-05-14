const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [[HEIGHT, WIDTH], ...PIECE_OF_CHEESE] = input;

const DIRECTION = [
  [1, 0],
  [-1, 0],
  [0, -1],
  [0, 1],
];

const findOutsideCheese = (pieceOfCheese) => {
  const queue = [[0, 0]];

  const visited = Array.from({ length: HEIGHT }, () =>
    Array(WIDTH).fill(false)
  );
  visited[0][0] = true;

  while (queue.length) {
    const [x, y] = queue.shift();

    for (const [dx, dy] of DIRECTION) {
      const nx = x + dx;
      const ny = y + dy;

      if (nx >= 0 && ny >= 0 && nx < WIDTH && ny < HEIGHT && !visited[ny][nx]) {
        if (pieceOfCheese[ny][nx] === 0) {
          visited[ny][nx] = true;
          queue.push([nx, ny]);
        } else if (pieceOfCheese[ny][nx] === 1) {
          pieceOfCheese[ny][nx] = 2;
          visited[ny][nx] = true;
        }
      }
    }
  }
};

let time = 0;
let cheeseCount = 0;
let isMelting = true;

while (isMelting) {
  findOutsideCheese(PIECE_OF_CHEESE);
  isMelting = false;
  let currentCheeseCount = 0;

  for (let i = 0; i < HEIGHT; i++) {
    for (let j = 0; j < WIDTH; j++) {
      if (PIECE_OF_CHEESE[i][j] === 2) {
        PIECE_OF_CHEESE[i][j] = 0;
        isMelting = true;
        currentCheeseCount++;
      }
    }
  }

  if (!isMelting) break;

  cheeseCount = currentCheeseCount;
  time++;
}

console.log(time);
console.log(cheeseCount);
