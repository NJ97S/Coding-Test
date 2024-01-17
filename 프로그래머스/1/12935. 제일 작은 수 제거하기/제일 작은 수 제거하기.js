function solution(arr) {
    let index = 0;
    if (arr.length === 1) {
        arr[0] = -1;
    } else {
        let min = arr[0];
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        arr.splice(index, 1);
    }
    
    return arr;
}