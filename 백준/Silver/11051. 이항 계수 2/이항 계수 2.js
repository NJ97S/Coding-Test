const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const [N, K] = input;

const getFactorial = (num) => {
  let factorialValue = BigInt(1);

  for (let i = num; i > 0; i--) {
    factorialValue *= BigInt(i);
  }

  return factorialValue;
};

const bigintValue =
  (getFactorial(N) / (getFactorial(N - K) * getFactorial(K))) % BigInt(10007);

console.log(Number(bigintValue));
