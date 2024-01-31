const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n").map(el=>el.split(" "));

// input 나눠서 정리
const N = +input[0][0];
const NO_LISTEN = new Set();
for (let i = 1; i <= N; i++) {
  NO_LISTEN.add(input[i][0]);
}
const M = +input[0][1]
const NO_SEE = new Array();
for (let i = 1 + N; i <= N + M; i++) {
  NO_SEE.push(input[i][0]);
}

// NO_SEE의 요소가 NO_LISTEN과 일치하는 경우, 해당 값 answer 배열에 추가
let count = 0;
let answer = [];

for (let elem of NO_SEE) {
  if (NO_LISTEN.has(elem)) {
    count++;
    answer.push(elem);
  }
}

// 듣보잡 명단 사전 순 정렬
answer.sort();

// 출력
console.log(count);

for (let elem of answer) {
  console.log(elem);
}