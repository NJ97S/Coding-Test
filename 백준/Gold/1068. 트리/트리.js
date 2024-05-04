const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [N, PARENT_NODES, DELETE_NODE] = input;

const tree = Array.from({ length: N }, () => []);
let root;

for (let i = 0; i < N; i++) {
  if (PARENT_NODES[i] === -1) {
    root = i;
  } else {
    tree[PARENT_NODES[i]].push(i);
  }
}

const countLeafNodes = (node) => {
  if (node === DELETE_NODE[0]) return 0;

  if (tree[node].length === 0) return 1;

  let numOfLeafs = 0;
  for (let child of tree[node]) {
    numOfLeafs += countLeafNodes(child);
  }

  return numOfLeafs ? numOfLeafs : 1;
};

const result = root === DELETE_NODE[0] ? 0 : countLeafNodes(root);
console.log(result);
