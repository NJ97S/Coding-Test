const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./example.txt").toString().trim().split("\n").map(el=>el.split(" ").map(Number));

// 각 행의 최댓값 찾기
let lineMax = [];

for (let i = 0; i < 9; i++) {
  lineMax[i] = Math.max(...input[i]);
}

// 전체 최댓값 찾기
let Max = Math.max(...lineMax);

// 최댓값 위치 찾기
let siteMax = '';

for (let i = 0; i < 9; i++) {
  for (let j = 0; j < 9; j++) {
    if(input[i][j] === Max) {
      siteMax = `${i+1} ${j+1}`;
    }
  }
}

// 값 출력
console.log(Max);
console.log(siteMax);