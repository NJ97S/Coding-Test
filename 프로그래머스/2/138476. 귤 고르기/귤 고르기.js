function solution(k, tangerine) {
    let sizeCounts = {};
    tangerine.forEach(size => sizeCounts[size] = (sizeCounts[size] || 0) + 1);

    let heap = Object.entries(sizeCounts).sort((a, b) => b[1] - a[1]);

    let types = 0;
    let selected = 0;
    while(selected < k) {
        let [size, count] = heap.shift();
        types++;
        selected += count;
    }

    return types;
}
