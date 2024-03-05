const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const [T, ...totalMoney] = input;

const MONEY_TYPE = {
  quarter: 25,
  dime: 10,
  nickel: 5,
  penny: 1,
};

for (let i = 0; i < totalMoney.length; i++) {
  change = [0, 0, 0, 0];

  while (totalMoney[i] > 0) {
    if (totalMoney[i] >= MONEY_TYPE.quarter) {
      totalMoney[i] -= MONEY_TYPE.quarter;
      change[0]++;
    } else if (totalMoney[i] >= MONEY_TYPE.dime) {
      totalMoney[i] -= MONEY_TYPE.dime;
      change[1]++;
    } else if (totalMoney[i] >= MONEY_TYPE.nickel) {
      totalMoney[i] -= MONEY_TYPE.nickel;
      change[2]++;
    } else {
      totalMoney[i] -= MONEY_TYPE.penny;
      change[3]++;
    }
  }

  console.log(...change);
}
