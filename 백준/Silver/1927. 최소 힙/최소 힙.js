const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

let minHeap = [];
let answer = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] !== 0) {
    minHeap.push(input[i]);
    bubbleUp(minHeap.length - 1);
  } else if (input[i] === 0) {
    if (!minHeap[0]) answer.push(0);
    else {
      answer.push(minHeap[0]);
      minHeap[0] = minHeap[minHeap.length - 1];
      minHeap.pop();
      bubbleDown(0);
    }
  }
}

function bubbleUp(index) {
  let parentIndex = Math.floor((index - 1) / 2);

  while (minHeap[index] < minHeap[parentIndex]) {
    [minHeap[index], minHeap[parentIndex]] = [
      minHeap[parentIndex],
      minHeap[index],
    ];
    index = parentIndex;
    parentIndex = Math.floor((index - 1) / 2);
  }
}

function bubbleDown(index) {
  while (index <= Math.floor(minHeap.length / 2 - 1)) {
    let leftChildIndex = index * 2 + 1;
    let rightChildIndex = index * 2 + 2;
    let smallerIndex = leftChildIndex;

    if (minHeap[rightChildIndex] < minHeap[leftChildIndex]) {
      smallerIndex = rightChildIndex;
    }

    if (minHeap[index] <= minHeap[smallerIndex]) break;

    [minHeap[index], minHeap[smallerIndex]] = [
      minHeap[smallerIndex],
      minHeap[index],
    ];

    index = smallerIndex;
  }
}

console.log(answer.join("\n"));
