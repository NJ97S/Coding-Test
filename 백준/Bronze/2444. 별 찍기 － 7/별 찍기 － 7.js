const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim();

drawStar(input);

function drawStar (N) {
  for (let i = 1; i <= 2 * N - 1; i++) {
    let oneLine = '';

    if (i <= N) {
      for (let j = 1; j <= N - i; j++) {
        oneLine += ' ';
      }
      for (let j = 1; j <= i * 2 - 1; j++) {
        oneLine += '*';
      }
      console.log(oneLine);
    }

    else if (i > N) {
      for (let j = 1; j <= i - N; j++) {
        oneLine += ' ';
      }
      for (let j = 1; j <= (2 * N - 1) - (i - N) * 2; j++) {
        oneLine += '*';
      }
      console.log(oneLine);
    }
  }
}