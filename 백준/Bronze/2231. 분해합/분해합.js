const input = +require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim();

let arr = [];

function answer (num) {
  let splitNum = num.toString().split('');
  return num + splitNum.reduce((acc, number) => (acc += parseInt(number)), 0);
}

for (let i = 1; i <= input; i++) {
  if (answer(i) === input) {
    arr.push(i);
  }
}

if (arr.length) {
  console.log(Math.min.apply(null, arr));
} else {
  console.log(0);
}