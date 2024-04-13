function calcTime(time) {
    const [hour, minute] = time.split(':').map(elem => +elem);
    return hour * 60 + minute;
}

function solution(book_time) {
    const map = new Map();
    
    for (const [startTime, endTime] of book_time) {
        let start = calcTime(startTime);
        let end = calcTime(endTime);
        for (; start < end + 10; start++) map.set(start, (map.get(start) || 0) + 1);
    }
    
    return Math.max(...map.values());
}