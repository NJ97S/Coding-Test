const input = require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");
let [N, ...terms] = input;

const termsSet = new Set(); // 중복 제거
for (let elem of terms) {
  termsSet.add(elem);
}

terms = Array.from(termsSet);

terms.sort(); // 사전 순 정렬

terms.sort((a, b) => (a.length - b.length));  // 길이 순 정렬

for (let term of terms) {
  console.log(term);
}