const input = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

const BUTTON = {
  A: 300,
  B: 60,
  C: 10,
};

let answer = [0, 0, 0];

if (input >= BUTTON.A) answer[0] = Math.floor(input / BUTTON.A);
if (input >= BUTTON.B) answer[1] = Math.floor((input % BUTTON.A) / BUTTON.B);
if (input >= BUTTON.C) answer[2] = Math.floor(((input % BUTTON.A) % BUTTON.B) / BUTTON.C);

if (((input % BUTTON.A) % BUTTON.B) % BUTTON.C) console.log(-1);
else console.log(...answer);
