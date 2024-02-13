const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

let maxHeap = [];
let answer = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] !== 0) {
    maxHeap.push(input[i]);
    bubbleUp(maxHeap.length - 1);
  } else if (input[i] === 0) {
    if (!maxHeap[0]) answer.push(0);
    else {
      answer.push(maxHeap[0]);
      maxHeap[0] = maxHeap[maxHeap.length - 1];
      maxHeap.pop();
      bubbleDown(0);
    }
  }
}

function bubbleUp(index) {
  let parentIndex = Math.floor((index - 1) / 2);

  while (maxHeap[index] > maxHeap[parentIndex]) {
    [maxHeap[index], maxHeap[parentIndex]] = [
      maxHeap[parentIndex],
      maxHeap[index],
    ];
    index = parentIndex;
    parentIndex = Math.floor((index - 1) / 2);
  }
}

function bubbleDown(index) {
  while (index <= Math.floor(maxHeap.length / 2 - 1)) {
    let leftChildIndex = index * 2 + 1;
    let rightChildIndex = index * 2 + 2;
    let biggerIndex = leftChildIndex;

    if (maxHeap[rightChildIndex] > maxHeap[leftChildIndex]) {
      biggerIndex = rightChildIndex;
    }

    if (maxHeap[index] >= maxHeap[biggerIndex]) break;

    [maxHeap[index], maxHeap[biggerIndex]] = [
      maxHeap[biggerIndex],
      maxHeap[index],
    ];

    index = biggerIndex;
  }
}

console.log(answer.join("\n"));
